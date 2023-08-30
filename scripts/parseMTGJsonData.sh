#!/bin/bash
set -x

RAW_DATA_DIR=/mnt/c/Users/jonat/Project/Data/MTG_data/rawData
DATA_DONE_DIR=/mnt/c/Users/jonat/Project/Data/MTG_data/parsedJsonDataForSolr/done
JAR_TARGET_DIR=/mnt/c/Users/jonat/Programming/MTG_SOLR_PREPROCESS/target
PROPERTY=../property/all_path.properties
ALLPRINTDATA=/mnt/c/Users/jonat/Project/Data/MTG_data/rawData/AllPrintings.json
PARSED_DATA_CURRENT=/mnt/c/Users/jonat/Project/Data/MTG_data/parsedJsonDataForSolr/current/
BACKUP_RAW_DATA=/mnt/c/Users/jonat/Project/Data/MTG_data/backupRawData/
S3_BUCKET=magic-the-gathering-s3
PREFIX=inbound/solr
numberRange="{1..10000} {10001..20000} {20001..30000} {30001..40000} {40001..50000} {50001..60000} {60001..70000} {80001..90000} {90001..100000}"
count=1


cd $RAW_DATA_DIR
wget https://mtgjson.com/api/v5/AllPrintings.json
rm $DATA_DONE_DIR/*

cd $JAR_TARGET_DIR
java -jar MTG_SOLR_PREPROCESS-1.0-SNAPSHOT-jar-with-dependencies.jar $PROPERTY $ALLPRINTDATA $PARSED_DATA_CURRENT

if [ $? != 0 ]
then
  exit 255
fi

timestamp=$(date "+%Y-%m-%d_%H-%M-%S")

cd $RAW_DATA_DIR
mv AllPrintings.json AllPrintings_${timestamp}.json
gzip AllPrintings*
mv AllPrintings* $BACKUP_RAW_DATA

cd $PARSED_DATA_CURRENT

for range in $numberRange
do
  tar -czf fullMTGdata.json_"$count"_"${timestamp}".tar.gz CardData"$range".json
  rm CardData"$range".json
  count=$((count + 1))
done

mv *tar.gz $DATA_DONE_DIR

aws s3 cp $DATA_DONE_DIR s3://$S3_BUCKET/$PREFIX --recursive