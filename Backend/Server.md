## Apache 사용하여 서버 띄워보기
* 참고 : https://velog.io/@yebali/Apache-Linux-Apache-%EC%84%A4%EC%B9%98%EB%B0%A9%EB%B2%95
1. AWS 프리티어 가입
2. EC2 - Cent OS7 인스턴스 생성 / 실행
3. apache 설치 (yum 설치 / 컴파일 설치)

### yum 설치
1. sudo yum install httpd => apache 설치
2. sudo systemctl start httpd => apache서버 시작
3. 80 포트 열어주기 (firewall-cmd)
```
sudo yum install firewalld
sudo firewall-cmd --zone=public --permanent --add-port=80/tcp // 80포트 열기
sudo firewall-cmd --reload // 방화벽 리로드
sudo firewall-cmd --zone=public --list-all // 열린 포트 확인
```

### 컴파일 설치
* 컴파일 설치가 일일이 설치해야할게 많아서 시간이 오래걸렸다.
1. wget을 통해 httpd-2.4.54.tar.gz 다운로드
2. 2.4버전부터 apr, apr-util이 모두 빠졌기 때문에 설치해줘야함
* wget을 통해 apr-1.7.0.tar.gz, apr-util-1.6.1.tar.gz 설치
* net-tools, gcc, gcc-c++, make 설치
3. tar파일들을 모두 압축해제한 후 apr, apr-util 파일들을 httpd-2.4.54/srclib/폴더로 이동
4. pcre-4.5 버전 wget을 통해 다운로드
* pcre-4.5폴더로 이동 후
```
./configure --prefix=/usr/local
make
make install
```
5. httpd-2.4.54 폴더 이동 후 설정 변경
* sudo yum install openssl-devel
* sudo yum install expat-devel
* 위 두개를 설치하여 오류를 해결
```
./configure \
--prefix=/usr/local/apache \
--enable-so \
--with-included-apr \
--enable-ssl=shared \
--enable-rewrite \
--enable-modules=most \
--enable-mods-shared=all
```
make -j 8 (8쓰레드 사용하여 컴파일)    
sudo make install

6. 서버를 시작해보기
```
cd /usr/local/apache/bin (Apache 설치한 경로)
sudo ./httpd -f /usr/local/apache/conf/httpd.conf -k start
```
* yum 설치처럼 systemctl로 관리하는방법
```
sudo cp /usr/local/apache/bin/apachectl /etc/init.d/httpd
sudo vi /etc/init.d/httpd

/*
#!/bin/sh
밑에 행에
# chkconfig: 2345 90 90
# description: init file for Apache server daemon
# processname: /usr/local/apache/bin/apachectl
# config: /usr/local/apache/conf/httpd.conf
# pidfile: /usr/local/apache/logs/httpd.pid
를 추가한다.
/usr/local/apache는 아파치 설치 경로이다.
*/

sudo chkconfig --add httpd
```

## Let's Encrypt ssl 적용하기
* 참고 : https://softone.tistory.com/64
### 설치순서
1. Apache Conf 설정
2. Certbot 설치 및 인증서 생성
3. https (443 port) 방화벽 해제
* 선택. 인증서 자동갱신 설정
* bogeun.ga 도메인으로 진행

### 1-1. Apache Conf 설정
* ssl 설정을 위해 가상 호스트가 설정되어 있어야한다.
```
# vi /etc/httpd/conf/httpd.conf 

# 본인의 도메인에 맞서 서버 도매인 적용 
ServerName bogeun.ga:80 

# 해당 설치 문서 root 설정 (default)
DocumentRoot "/var/www/html"
```

### 1-2. 가상호스트 설정
```
# vi /etc/httpd/conf.d/httpd-vhost.conf

<VirtualHost *:80>
DocumentRoot "/var/www/html"
ServerName bogeun.ga
</VirtualHost>
```

### 1-3. SSL 접속 도메인 설정
```
# vi /etc/httpd/conf.d/ssl.conf

<VirtualHost *:443>
DocumentRoot "/var/www/html"
ServerName bogeun.ga:443
```

### 2-1. Cerbot 설치
```
# yum install certbot-apache
// 설치하며 나오는 질문에 yes, 이메일을 입력하면 된다.
```

### 2-2. 설정된 ssl확인
```
# vi /etc/httpd/conf.d/ssl.conf

SSLCertificateFile /etc/letsencrypt/live/bogeun.ga/cert.pem
SSLCertificateKeyFile /etc/letsencrypt/live/bogeun.ga/privkey.pem
SSLCertificateChainFile /etc/letsencrypt/live/bogeun.ga/chain.pem
```

### 3. 방화벽 443 포트 해제
1. firewall-cmd --list-all // 현재 방화벽 확인
2. firewall-cmd --permanent --zone=public --add-port=443/tcp // 443포트 추가
3. firewall-cmd --reload // 방화벽 리로드

### 추가
* #systemctl restart httpd // Apache 서버 재시작
