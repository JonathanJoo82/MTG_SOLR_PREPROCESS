#!/bin/bash
set -x

RAW_DATA_DIR=/mnt/c/Users/jonat/Project/Data/MTG_data/rawData
DATA_DONE_DIR=/mnt/c/Users/jonat/Project/Data/MTG_data/parsedJsonDataForSolr/done/
JAR_TARGET_DIR=/mnt/c/Users/jonat/Programming/MTG_SOLR_PREPROCESS/target
PROPERTY=../property/all_path.properties
ALLPRINTDATA=/mnt/c/Users/jonat/Project/Data/MTG_data/rawData/AllPrintings.json
PARSED_DATA_CURRENT=/mnt/c/Users/jonat/Project/Data/MTG_data/parsedJsonDataForSolr/current/
BACKUP_RAW_DATA=/mnt/c/Users/jonat/Project/Data/MTG_data/backupRawData/


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

tar -czf fullMTGdata.json_1_10000_${timestamp}.tar.gz CardData{1..10000}.json
rm CardData{1..10000}.json
tar -czf fullMTGdata.json_10001_20000_${timestamp}.tar.gz CardData{10001..20000}.json
rm CardData{10001..20000}.json
tar -czf fullMTGdata.json_20001_30000_${timestamp}.tar.gz CardData{20001..30000}.json
rm CardData{20001..30000}.json
tar -czf fullMTGdata.json_30001_40000_${timestamp}.tar.gz CardData{30001..4000}.json
rm CardData{30001..40000}.json
tar -czf fullMTGdata.json_40001_50000_${timestamp}.tar.gz CardData{40001..50000}.json
rm  CardData{40001..50000}.json
tar -czf fullMTGdata.json_50001_60000_${timestamp}.tar.gz CardData{50001..60000}.json
rm CardData{50001..60000}.json
tar -czf fullMTGdata.json_60001_70000_${timestamp}.tar.gz CardData{60001..70000}.json
rm CardData{60001..70000}.json
tar -czf fullMTGdata.json_70001_80000_${timestamp}.tar.gz CardData{70001..80000}.json
rm CardData{70001..80000}.json
tar -czf fullMTGdata.json_80001_90000_${timestamp}.tar.gz CardData{80001..90000}.json
rm CardData{80001..90000}.json
tar -czf fullMTGdata.json_90001_100000_${timestamp}.tar.gz CardData{90001..100000}.json
rm CardData{90001..100000}.json

mv *tar.gz $DATA_DONE_DIR

