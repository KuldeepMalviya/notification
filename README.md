# notification

To add logs all put api at "host:8080/data" with body like 
{
"eventTime" : "2020-07-17T23:08:14.952",
"eventType" : "BLOCKER",
"message" : "event message"
}	

all posible EventTypes are 
   CRITICAL,
   INFO,
   WARNING,
   BLOCKER

For update/change configration, update properties available in application.yml file.


