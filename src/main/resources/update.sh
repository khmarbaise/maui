#!/bin/bash
#find . -type f -name "pom.xml" | xargs grep "com.soebes.smpp" | cut -d":" -f1 | xargs -I % dirname % | xargs -I {} cd {};mvn versions:update-parent; cd ..
PROJECT_LIST=`find . -type f -name "pom.xml" | xargs grep "com.soebes.smpp" | cut -d":" -f1 | xargs -I % dirname %`
for i in $PROJECT_LIST; do
  cd $i
  echo "Updating version of $i"
  mvn versions:update-parent
  echo "done." 
  cd ..
done;
