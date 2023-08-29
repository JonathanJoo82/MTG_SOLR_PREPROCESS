package com.mtgSolr.Utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mtgSolr.dao.Card;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JsonParserUtils {


    static int count = 0;

    public void getSetData(JSONObject dataMap, String arg) {
        Set<String> keyList = new HashSet<>();
        for (int i = 0; i < dataMap.size(); i++) {
            keyList = dataMap.keySet();
        }

        for (String key : keyList) {
            JSONObject setData = (JSONObject) dataMap.get(key);
            parseCardDataObject(setData, arg);
        }
    }

    public void parseCardDataObject(JSONObject jsonObject, String arg) {
        Card card = new Card();
        JSONArray jsonArray = (JSONArray) jsonObject.get("cards");
        for (Object o : jsonArray) {
            count++;

            JSONObject cardData = (JSONObject) o;

            if (cardData.get("artist") != null) {
                card.setArtist(cardData.get("artist").toString());
            }

            if (cardData.get("edhrecRank") != null) {
                card.setEdhrecRank(cardData.get("edhrecRank").toString());
            }

            if (cardData.get("manaCost") != null) {
                card.setManaCost(cardData.get("manaCost").toString());
            }

            if (cardData.get("originalText") != null) {
                card.setOriginalText(cardData.get("originalText").toString());
            }

            if (cardData.get("originalType") != null) {
                card.setOriginalType(cardData.get("originalType").toString());
            }

            if (cardData.get("power") != null) {
                card.setPower(cardData.get("power").toString());
            }

            if (cardData.get("toughness") != null) {
                card.setToughness(cardData.get("toughness").toString());
            }

            if (cardData.get("type") != null) {
                card.setType(cardData.get("type").toString());
            }

            if (cardData.get("text") != null) {
                card.setText(cardData.get("text").toString());
            }

            card.setAvailabilty((JSONArray) cardData.get("availability"));
            card.setBorderColor(cardData.get("borderColor").toString());
            card.setColorIdentity((JSONArray) cardData.get("colorIdenity"));
            card.setColors((JSONArray) cardData.get("colors"));
            card.setConvertedManaCost((cardData.get("convertedManaCost").toString()));
            card.setFrameEffects((JSONArray) cardData.get("frameEffects"));
            card.setFrameVersion(cardData.get("frameVersion").toString());
            card.setHasFoil(Boolean.parseBoolean(cardData.get("hasFoil").toString()));
            card.setHasNonFoil(Boolean.parseBoolean(cardData.get("hasNonFoil").toString()));
            card.setKeywords((JSONArray) cardData.get("keywords"));
            card.setLayout(cardData.get("layout").toString());
            card.setName(cardData.get("name").toString());
            card.setNumber(cardData.get("number").toString());
            card.setPrintings((JSONArray) cardData.get("printings"));
            card.setRarity(cardData.get("rarity").toString());
            card.setSetCode(cardData.get("setCode").toString());
            card.setSubtypes((JSONArray) cardData.get("subtypes"));
            card.setSuperTypes((JSONArray) cardData.get("superTypes"));
            card.setTypes((JSONArray) cardData.get("types"));
            card.setUuid(cardData.get("uuid").toString());

            setForeignCardData(card, cardData);
            setIdentifiersCardData(card, cardData);
            setLegalities(card, cardData);
            setPurchaseUrls(card, cardData);

            setGlobalFields(card, jsonObject);

            //convert the object to jsonformat
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            try{
                String json = mapper.writeValueAsString(card);
                writeCardJsonToFile(json, count, arg);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


        }
    }

    private void setGlobalFields(Card card, JSONObject jsonObject) {
        card.setBaseSetSize(jsonObject.get("baseSetSize").toString());

        if(jsonObject.get("block") != null){
            card.setBlock(jsonObject.get("block").toString());
        }

        card.setCode(jsonObject.get("code").toString());
        card.setKeyRuneCode(jsonObject.get("keyruneCode").toString());

        if(jsonObject.get("mcmId") != null){
            card.setMcmID(jsonObject.get("mcmId").toString());
        }

        if(jsonObject.get("mcmName")!=null){
            card.setMcmName(jsonObject.get("mcmName").toString());
        }

        if (jsonObject.get("mtgoCode") != null) {
            card.setMtgoCode(jsonObject.get("mtgoCode").toString());
        }

        card.setReleaseDate(jsonObject.get("releaseDate").toString());

        if(jsonObject.get("tcgplayerGroupId") != null){
            card.setTcgPlayerGroupId(jsonObject.get("tcgplayerGroupId").toString());
        }

        card.setTotalSetSize(jsonObject.get("totalSetSize").toString());
        card.setSetType(jsonObject.get("type").toString());

        setTranslationPopulator(card, jsonObject);
    }

    private void setTranslationPopulator(Card card, JSONObject jsonObject) {
        JSONObject foreignCardSetData = (JSONObject) jsonObject.get("translations");

        if(foreignCardSetData.size() > 0){
            if(foreignCardSetData.get("Chinese Simplified") != null){
                card.setSetLanguageChineseSimplified(foreignCardSetData.get("Chinese Simplified").toString());
            }

            if(foreignCardSetData.get("Chinese Traditional") != null){
                card.setSetLanguageChineseTraditional(foreignCardSetData.get("Chinese Traditional").toString());
            }

            if(foreignCardSetData.get("French") != null){
                card.setSetLanguageFrench(foreignCardSetData.get("French").toString());
            }

            if(foreignCardSetData.get("German") != null){
                card.setSetLanguageGerman(foreignCardSetData.get("German").toString());
            }

            if(foreignCardSetData.get("Italian") != null){
                card.setSetLanguageItalian(foreignCardSetData.get("Italian").toString());
            }

            if(foreignCardSetData.get("Japanese") != null){
                card.setSetLanguageJapanese(foreignCardSetData.get("Japanese").toString());
            }

            if(foreignCardSetData.get("Korean") != null){
                card.setSetLanguageKorean(foreignCardSetData.get("Korean").toString());
            }

            if(foreignCardSetData.get("Portuguese (Brazil)") != null){
                card.setSetLanguagePortuguese(foreignCardSetData.get("Portuguese (Brazil)").toString());
            }

            if(foreignCardSetData.get("Russian") != null){
                card.setSetLanguageRussian(foreignCardSetData.get("Russian").toString());
            }

            if(foreignCardSetData.get("Spanish") != null){
                card.setSetLanguageSpanish(foreignCardSetData.get("Spanish").toString());
            }
        }
    }

    private void setForeignCardData(Card card, JSONObject cardData) {
        JSONArray foreignCardData = (JSONArray) cardData.get("foreignData");

        for (Object foreignCardDatum : foreignCardData) {
            JSONObject object = (JSONObject) foreignCardDatum;
            String language = object.get("language").toString();
            switch (language) {
                case "German":
                    Map<String, String> germanMap = new HashMap<>();
                    populateMap(germanMap, object);
                    card.setForeignGermanName(germanMap.get("name"));
                    card.setForeignGermanLanugage(germanMap.get("language"));
                    card.setForeignGermanText(germanMap.get("text"));
                    card.setForeignGermanType(germanMap.get("type"));
                    break;

                case "Spanish":
                    Map<String, String> spanishMap = new HashMap<>();
                    populateMap(spanishMap, object);
                    card.setForeignSpanishName(spanishMap.get("name"));
                    card.setForeignSpanishLanguage((spanishMap.get("language")));
                    card.setForeignSpanishText(spanishMap.get("text"));
                    card.setForeignSpanishType(spanishMap.get("type"));
                    break;

                case "French":
                    Map<String, String> frenchMap = new HashMap<>();
                    populateMap(frenchMap, object);
                    card.setForeignFrenchName(frenchMap.get("name"));
                    card.setForeignFrenchLanugage(frenchMap.get("language"));
                    card.setForeignFrenchText(frenchMap.get("text"));
                    card.setForeignFrenchType(frenchMap.get("type"));
                    break;

                case "Italian":
                    Map<String, String> italianMap = new HashMap<>();
                    populateMap(italianMap, object);
                    card.setForeignItalianName(italianMap.get("name"));
                    card.setForeignItalianLanguage(italianMap.get("language"));
                    card.setForeignItalianText(italianMap.get("text"));
                    card.setForeignItalianType(italianMap.get("type"));
                    break;

                case "Japanese":
                    Map<String, String> japaneseMap = new HashMap<>();
                    populateMap(japaneseMap, object);
                    card.setForeignJapaneseName(japaneseMap.get("name"));
                    card.setForeignJapaneseLanguage(japaneseMap.get("language"));
                    card.setForeignJapaneseText(japaneseMap.get("text"));
                    card.setForeignJapaneseType(japaneseMap.get("type"));
                    break;

                case "Korean":
                    Map<String, String> koreanMap = new HashMap<>();
                    populateMap(koreanMap, object);
                    card.setForeignKoreanName(koreanMap.get("name"));
                    card.setForeignKoreanLanguage(koreanMap.get("language"));
                    card.setForeignKoreanText(koreanMap.get("text"));
                    card.setForeignKoreanType(koreanMap.get("type"));
                    break;

                case "Portuguese (Brazil)":
                    Map<String, String> portugueseMap = new HashMap<>();
                    populateMap(portugueseMap, object);
                    card.setForeignPortugueseName(portugueseMap.get("name"));
                    card.setForeignPortugueseLanguage(portugueseMap.get("language"));
                    card.setForeignPortugueseText(portugueseMap.get("text"));
                    card.setForeignPortugueseType(portugueseMap.get("type"));
                    break;

                case "Russian":
                    Map<String, String> russianMap = new HashMap<>();
                    populateMap(russianMap, object);
                    card.setForeignRussianName(russianMap.get("name"));
                    card.setForeignRussianLanguage(russianMap.get("language"));
                    card.setForeignRussianText(russianMap.get("text"));
                    card.setForeignRussianType(russianMap.get("type"));
                    break;

                case "Chinese Simplified":
                    Map<String, String> chineseSimpleMap = new HashMap<>();
                    populateMap(chineseSimpleMap, object);
                    card.setForeignChineseSimplifedName(chineseSimpleMap.get("name"));
                    card.setForeignChineseSimplifedLanguage(chineseSimpleMap.get("language"));
                    card.setForeignChineseSimplifedText(chineseSimpleMap.get("text"));
                    card.setForeignChineseSimplifedType(chineseSimpleMap.get("type"));
                    break;

                case "Chinese Traditional":
                    Map<String, String> chineseTradMap = new HashMap<>();
                    populateMap(chineseTradMap, object);
                    card.setForeignChineseTraditionalName(chineseTradMap.get("name"));
                    card.setForeignChineseTraditionalLanguage(chineseTradMap.get("language"));
                    card.setForeignChineseTraditionalText(chineseTradMap.get("text"));
                    card.setForeignChineseTraditionalType(chineseTradMap.get("type"));
                    break;

                default:
                    break;
            }
        }

    }

    private void populateMap(Map<String, String> map, JSONObject object) {
        String name = object.get("name").toString();
        String language = object.get("language").toString();

        String text = "";
        if (object.get("text") != null) {
            text = object.get("text").toString();
        }

        String type = "";
        if (object.get("type") != null) {
            type = object.get("type").toString();
        }

        map.put("name", name);
        map.put("language", language);
        map.put("text", text);
        map.put("type", type);
    }

    private void setLegalities(Card card, JSONObject cardData) {
        JSONObject legalities = (JSONObject) cardData.get("legalities");
        String commander;
        String duel;
        String legacy;
        String modern;
        String penny;
        String vintage;
        String pioneer;

        if (legalities.get("commander") != null) {
            commander = legalities.get("commander").toString();
            if(commander.equals("Legal")){
                card.setLegalitiesCommander(commander);
                card.setLegalCommander(true);
            }

        }

        if (legalities.get("duel") != null) {
            duel = legalities.get("duel").toString();
            if(duel.equals("Legal")){
                card.setLegalitiesDuel(duel);
                card.setLegalDuel(true);
            }
        }

        if (legalities.get("legacy") != null) {
            legacy = legalities.get("legacy").toString();
            if(legacy.equals("Legal")){
                card.setLegalitiesLegacy(legacy);
                card.setLegalLegacy(true);
            }
        }

        if (legalities.get("modern") != null) {
            modern = legalities.get("modern").toString();
            if(modern.equals("Legal")){
                card.setLegalitiesModern(modern);
                card.setLegalModern(true);
            }
        }

        if (legalities.get("penny") != null) {
            penny = legalities.get("penny").toString();
            card.setIdentifierMtgJsonv4Id(penny);
        }

        if (legalities.get("vintage") != null) {
            vintage = legalities.get("vintage").toString();
            if(vintage.equals("Legal")){
                card.setLegalitiesVintage(vintage);
                card.setLegalVintage(true);
            }
        }

        if (legalities.get("pioneer") != null) {
            pioneer = legalities.get("pioneer").toString();
            if(pioneer.equals("Legal")){
                card.setLegalitiesPioneer(pioneer);
                card.setLegalPioneer(true);
            }
        }
    }

    private void setIdentifiersCardData(Card card, JSONObject cardData) {

        JSONObject identifier = (JSONObject) cardData.get("identifiers");

        String cardKingdomFoilID;
        String cardKingdomID;
        String mcmID;
        String mcmMetaID;
        String mtgjsonV4Id;
        String mtgoFoilId;
        String mtgoId;
        String multiverseId;
        String scryfallId;
        String scryfallIllustrationId;
        String scryfallOracleId;
        String tcgplayerProductId;

        if (identifier.get("cardKingdomFoilId") != null) {
            cardKingdomFoilID = identifier.get("cardKingdomFoilId").toString();
            card.setIdentifierCardKingdomFoilId(cardKingdomFoilID);
        }

        if (identifier.get("cardKingdomId") != null) {
            cardKingdomID = identifier.get("cardKingdomId").toString();
            card.setIdentifierCardKingdomIdl(cardKingdomID);
        }

        if (identifier.get("mcmId") != null) {
            mcmID = identifier.get("mcmId").toString();
            card.setIdentifierMcmId(mcmID);
        }

        if (identifier.get("mcmMetaId") != null) {
            mcmMetaID = identifier.get("mcmMetaId").toString();
            card.setIdentifierMcmMetaId(mcmMetaID);
        }

        if (identifier.get("mtgjsonV4Id") != null) {
            mtgjsonV4Id = identifier.get("mtgjsonV4Id").toString();
            card.setIdentifierMtgJsonv4Id(mtgjsonV4Id);
        }

        if(identifier.get("mtgoFoilId") != null){
            mtgoFoilId = identifier.get("mtgoFoilId").toString();
            card.setIdentifierMtgoFoilId(mtgoFoilId);
        }

        if(identifier.get("mtgoId") != null){
            mtgoId = identifier.get("mtgoId").toString();
            card.setIdentifierMtgoId(mtgoId);
        }

        if(identifier.get("multiverseId") != null){
            multiverseId = identifier.get("multiverseId").toString();
            card.setIdentifierMultiverseID(multiverseId);
        }

        if(identifier.get("scryfallId") != null){
            scryfallId = identifier.get("scryfallId").toString();
            card.setIdentifierScryFallId(scryfallId);
        }

        if(identifier.get("scryfallIllustrationId") != null){
            scryfallIllustrationId = identifier.get("scryfallIllustrationId").toString();
            card.setIdentifierScryFallIllustrationId(scryfallIllustrationId);
        }

        if(identifier.get("scryfallOracleId") != null){
            scryfallOracleId = identifier.get("scryfallOracleId").toString();
            card.setIdentifierScryFallOracleId(scryfallOracleId);
        }

        if(identifier.get("tcgplayerProductId") != null){
            tcgplayerProductId = identifier.get("tcgplayerProductId").toString();
            card.setIdentifierTcgPlayerProductId(tcgplayerProductId);
        }
    }

    private void setPurchaseUrls(Card card, JSONObject cardData) {

        String cardKingdom;
        String cardKingdomFoil;
        String cardmarket;
        String tcgplayer;

        JSONObject purchaseUrls = (JSONObject) cardData.get("purchaseUrls");

        if(purchaseUrls.get("cardKingdom") != null){
            cardKingdom = purchaseUrls.get("cardKingdom").toString();
            card.setPurchaseUrlCardKingdom(cardKingdom);
        }

        if(purchaseUrls.get("cardKingdomFoil") != null){
            cardKingdomFoil = purchaseUrls.get("cardKingdomFoil").toString();
            card.setPurchaseUrlCardKingdomFoil(cardKingdomFoil);
        }

        if(purchaseUrls.get("cardmarket") != null){
            cardmarket = purchaseUrls.get("cardmarket").toString();
            card.setPurchaseUrlCardMarket(cardmarket);
        }

        if(purchaseUrls.get("tcgplayer") != null){
            tcgplayer = purchaseUrls.get("tcgplayer").toString();
            card.setPurchaseUrlTcgPlayer(tcgplayer);
        }
    }

    public void writeCardJsonToFile(String json, int number, String arg) {

        try {
            File jsonFile = new File(arg +"CardData"+ number + ".json");
            jsonFile.setWritable(false);
            jsonFile.setReadable(true);
            System.out.println(jsonFile.getAbsolutePath());
            FileWriter file = new FileWriter(jsonFile);
            file.write(json);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
