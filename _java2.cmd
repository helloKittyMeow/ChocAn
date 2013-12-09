@echo off
cls

set cmd1=X:
set cmd2=cd Desktop\FourPlay
set cmd3=set "PATH=%path%;C:\Program Files\Java\jdk1.6.0_37\bin"
::set cmd3=set "PATH=C:\Program Files\Java\jdk1.7.0_25\bin;%PATH%"

::cmd /K "%cmd1% & %cmd2% & %cmd3%"

cmd /K "X: & cd Desktop\ChocAn & set PATH=%path%;C:\Program Files\Java\jdk1.7.0_45\bin"