# 네이버 검색결과를 이미지로 변환하여 주기적으로 보여줍니다.[![Build Status](https://travis-ci.org/area1211/demo-springboot-webservice.svg?branch=master)](https://travis-ci.org/area1211/demo-springboot-webservice)

[![Video Label](http://img.youtube.com/vi/hxMAYzFn7Ko/0.jpg)](https://youtu.be/hxMAYzFn7Ko?t=0s)


Spring Boot + Spring Batch + Quartz 를 사용하여 개발한 웹서비스입니다.  
사용자가 등록한 검색어로 주기적으로 최신 뉴스를 검색하여 크롤링한 후 스크린샷 이미지로 저장하여 보여줍니다.

크롤링하여 스크린샷 이미지로 저장하는 부분은 Spring Batch의 Job으로 구현하였으며   
Quartz를 사용하여 주기적으로 job이 실행되게 스케줄링합니다.  
[Spring Batch + Quartz Github](https://github.com/area1211/deom-spring-batch-quartz.git)
