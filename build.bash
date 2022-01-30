

set ff=UNIX
mkdir runContain
find ./src -name "*.java" -print0|xargs -0 javac -d runContain -cp ./antlr-4.9.2-complete.jar