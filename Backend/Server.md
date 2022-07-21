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
