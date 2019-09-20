FROM ubuntu:14.04
MAINTAINER KiranKumar

# Make sure the package repository is up to date.
RUN apt-get update && apt-get -y upgrade
RUN apt-get install -y git

# Install a basic SSH server
RUN apt-get install -y openssh-server &&   sed -i 's|session    required     pam_loginuid.so|session    optional     pam_loginuid.so|g' /etc/pam.d/sshd && mkdir -p /var/run/sshd

# Add user jenkins to the image
RUN adduser --quiet jenkins
# Set password for the jenkins user (you may want to alter this).
RUN echo "jenkins:jenkins" | chpasswd
#Install JDK

RUN apt-get install -y software-properties-common
RUN add-apt-repository ppa:openjdk-r/ppa
RUN apt-get update

RUN pat-get install -y openjdk-8-jdk

RUN mkdir /home/jenkins/.m2
RUN chown _R jenkins:jenkisn /home/jenkins/.m2



RUN wget  http://mirrors.estointernet.in/apache/maven/maven-3/3.6.1/binaries/apache-maven-3.6.1-bin.tar.gz 
    
RUN tar -xvf apache-maven-3.6.1 maven-3
ENV MAVEN_OPTS="Xm1024m -Dhttps.protocols=TLSV1,TLSv1.1,TLSv1.2"


# Standard SSH port
EXPOSE 22

CMD ["/usr/sbin/sshd", "-D"]
