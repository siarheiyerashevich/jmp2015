1. Serial Collector with the following parameters
-Xms6M -Xmx18M -XX:NewSize=2M -XX:+UseSerialGC -verbosegc

2.Parallel Collector with the following parameters
-Xms3M -Xmx12M -XX:NewSize=1M -XX:+UseParallelGC -verbosegc

3.Parallel Old Collector with the following parameters
-Xms9M -Xmx18M -XX:NewSize=3M -XX:+UseParallelOldGC -verbosegc

4.Concurrent Mark Sweep (CMS) Collector  with 2 Parallel CMS Threads  with the following parameters
-Xms6M -Xmx18M -XX:NewSize=2M -XX:+UseConcMarkSweepGC -verbosegc

5.G1 Garbage Collector with the following parameters
-Xms4M -Xmx16M -XX:NewSize=2M –XX:+UseG1GC –XX:+PrintGCDetails –XX:+PrintGCTimeStamps -verbosegc