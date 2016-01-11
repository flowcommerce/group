FROM giltarchitecture/ubuntu-jvm:0.6

MAINTAINER paolo@flow.io

ADD . /usr/share/fulfillment

WORKDIR /usr/share/fulfillment

RUN sbt -Dsbt.ivy.home=.ivy2 clean stage

RUN ln -s /usr/share/fulfillment/api/target/universal/stage /usr/share/fulfillment-api
RUN ln -s /usr/share/fulfillment/www/target/universal/stage /usr/share/fulfillment-www
