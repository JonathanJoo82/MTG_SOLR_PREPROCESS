package com.mtgSolr.dao;

import org.json.simple.JSONArray;

public class Card {

    private String artist;
    private JSONArray availabilty;
    private String borderColor;
    private JSONArray colorIdentity;
    private JSONArray colors;
    private String convertedManaCost;
    private String edhrecRank;
    private JSONArray frameEffects;
    private String frameVersion;
    private boolean hasFoil;
    private boolean hasNonFoil;
    private JSONArray keywords;
    private String layout;
    private String manaCost;
    private String name;
    private String number;
    private String originalText;
    private String originalType;
    private String power;
    private JSONArray printings;
    private String rarity;
    private String setCode;
    private JSONArray subtypes;
    private JSONArray superTypes;
    private String text;
    private String toughness;
    private String type;
    private JSONArray types;
    private String uuid;


    //global attributes to each card.
    private String baseSetSize;
    private String code;
    private String block;
    private String keyRuneCode;
    private String mcmID;
    private String mcmName;
    private String mtgoCode;
    private String releaseDate;
    private String tcgPlayerGroupId;
    private String totalSetSize;
    private String setType;
    private String setLanguageChineseSimplified;
    private String setLanguageChineseTraditional;
    private String setLanguageFrench;
    private String setLanguageGerman;
    private String setLanguageItalian;
    private String setLanguageJapanese;
    private String setLanguageKorean;
    private String setLanguagePortuguese;
    private String setLanguageRussian;
    private String setLanguageSpanish;

    /*
    keys: language, multiverseId, name, text, type
     */

    private String foreignGermanName;
    private String foreignGermanLanugage;
    private String foreignGermanText;
    private String foreignGermanType;

    private String foreignSpanishName;
    private String foreignSpanishLanguage;
    private String foreignSpanishText;
    private String foreignSpanishType;

    private String foreignFrenchName;
    private String foreignFrenchLanugage;
    private String foreignFrenchText;
    private String foreignFrenchType;

    private String foreignItalianName;
    private String foreignItalianLanguage;
    private String foreignItalianText;
    private String foreignItalianType;

    private String foreignJapaneseName;
    private String foreignJapaneseLanuage;
    private String foreignJapaneseText;
    private String foreignJapaneseType;

    private String foreignKoreanName;
    private String foreignKoreanLanguage;
    private String foreignKoreanText;
    private String foreignKoreanType;

    private String foreignPortugueseName;
    private String foreignPortugueseLanguage;
    private String foreignPortugueseText;
    private String foreignPortugueseType;

    private String foreignRussianName;
    private String foreignRussianLanguage;
    private String foreignRussianText;
    private String foreignRussianType;

    private String foreignChineseSimplifedName;
    private String foreignChineseSimplifedLanguage;
    private String foreignChineseSimplifedText;
    private String foreignChineseSimplifedType;

    private String foreignChineseTraditionalName;
    private String foreignChineseTraditionalLanguage;
    private String foreignChineseTraditionalText;
    private String foreignChineseTraditionalType;

    private String legalitiesCommander;
    private String legalitiesDuel;
    private String legalitiesLegacy;
    private String legalitiesModern;
    private String legalitiesPioneer;
    private String legalitiesVintage;

    private boolean isLegalCommander;
    private boolean isLegalDuel;
    private boolean isLegalLegacy;
    private boolean isLegalModern;
    private boolean isLegalPioneer;
    private boolean isLegalVintage;

    private String purchaseUrlCardKingdom;
    private String purchaseUrlCardKingdomFoil;
    private String purchaseUrlCardMarket;
    private String purchaseUrlTcgPlayer;

    private String identifierCardKingdomFoilId;
    private String identifierCardKingdomIdl;
    private String identifierMcmId;
    private String identifierMcmMetaId;
    private String identifierMtgJsonv4Id;
    private String identifierMtgoFoilId;
    private String identifierMtgoId;
    private String identifierScryFallId;
    private String identifierScryFallIllustrationId;
    private String identifierScryFallOracleId;
    private String identifierTcgPlayerProductId;
    private String identifierMultiverseID;

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAvailabilty(JSONArray availabilty) {
        this.availabilty = availabilty;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setColorIdentity(JSONArray colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public void setColors(JSONArray colors) {
        this.colors = colors;
    }

    public void setConvertedManaCost(String convertedManaCost) {
        this.convertedManaCost = convertedManaCost;
    }

    public void setEdhrecRank(String edhrecRank) {
        this.edhrecRank = edhrecRank;
    }

    public void setFrameEffects(JSONArray frameEffects) {
        this.frameEffects = frameEffects;
    }

    public void setFrameVersion(String frameVersion) {
        this.frameVersion = frameVersion;
    }

    public void setHasFoil(boolean hasFoil) {
        this.hasFoil = hasFoil;
    }

    public void setHasNonFoil(boolean hasNonFoil) {
        this.hasNonFoil = hasNonFoil;
    }

    public void setKeywords(JSONArray keywords) {
        this.keywords = keywords;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public void setOriginalType(String originalType) {
        this.originalType = originalType;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setPrintings(JSONArray printings) {
        this.printings = printings;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public void setSubtypes(JSONArray subtypes) {
        this.subtypes = subtypes;
    }

    public void setSuperTypes(JSONArray superTypes) {
        this.superTypes = superTypes;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTypes(JSONArray types) {
        this.types = types;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setKeyRuneCode(String keyRuneCode) {
        this.keyRuneCode = keyRuneCode;
    }

    public void setMcmID(String mcmID) {
        this.mcmID = mcmID;
    }

    public void setMcmName(String mcmName) {
        this.mcmName = mcmName;
    }

    public void setMtgoCode(String mtgoCode) {
        this.mtgoCode = mtgoCode;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTcgPlayerGroupId(String tcgPlayerGroupId) {
        this.tcgPlayerGroupId = tcgPlayerGroupId;
    }

    public void setTotalSetSize(String totalSetSize) {
        this.totalSetSize = totalSetSize;
    }

    public void setSetType(String setType) {
        this.setType = setType;
    }

    public void setSetLanguageChineseSimplified(String setLanguageChineseSimplified) {
        this.setLanguageChineseSimplified = setLanguageChineseSimplified;
    }

    public void setSetLanguageChineseTraditional(String setLanguageChineseTraditional) {
        this.setLanguageChineseTraditional = setLanguageChineseTraditional;
    }

    public void setSetLanguageFrench(String setLanguageFrench) {
        this.setLanguageFrench = setLanguageFrench;
    }

    public void setSetLanguageGerman(String setLanguageGerman) {
        this.setLanguageGerman = setLanguageGerman;
    }

    public void setSetLanguageItalian(String setLanguageItalian) {
        this.setLanguageItalian = setLanguageItalian;
    }

    public void setSetLanguageJapanese(String setLanguageJapanese) {
        this.setLanguageJapanese = setLanguageJapanese;
    }

    public void setSetLanguageKorean(String setLanguageKorean) {
        this.setLanguageKorean = setLanguageKorean;
    }

    public void setSetLanguagePortuguese(String setLanguagePortuguese) {
        this.setLanguagePortuguese = setLanguagePortuguese;
    }

    public void setSetLanguageRussian(String setLanguageRussian) {
        this.setLanguageRussian = setLanguageRussian;
    }

    public void setSetLanguageSpanish(String setLanguageSpanish) {
        this.setLanguageSpanish = setLanguageSpanish;
    }

    public void setLegalitiesCommander(String legalitiesCommander) {
        this.legalitiesCommander = legalitiesCommander;
    }

    public void setLegalitiesDuel(String legalitiesDuel) {
        this.legalitiesDuel = legalitiesDuel;
    }

    public void setLegalitiesLegacy(String legalitiesLegacy) {
        this.legalitiesLegacy = legalitiesLegacy;
    }

    public void setLegalitiesModern(String legalitiesModern) {
        this.legalitiesModern = legalitiesModern;
    }

    public void setLegalitiesPioneer(String legalitiesPioneer) {
        this.legalitiesPioneer = legalitiesPioneer;
    }

    public void setLegalitiesVintage(String legalitiesVintage) {
        this.legalitiesVintage = legalitiesVintage;
    }

    public void setLegalCommander(boolean legalCommander) {
        isLegalCommander = legalCommander;
    }

    public void setLegalDuel(boolean legalDuel) {
        isLegalDuel = legalDuel;
    }

    public void setLegalLegacy(boolean legalLegacy) {
        isLegalLegacy = legalLegacy;
    }

    public void setLegalModern(boolean legalModern) {
        isLegalModern = legalModern;
    }

    public void setLegalPioneer(boolean legalPioneer) {
        isLegalPioneer = legalPioneer;
    }

    public void setLegalVintage(boolean legalVintage) {
        isLegalVintage = legalVintage;
    }

    public void setPurchaseUrlCardKingdom(String purchaseUrlCardKingdom) {
        this.purchaseUrlCardKingdom = purchaseUrlCardKingdom;
    }

    public void setPurchaseUrlCardKingdomFoil(String purchaseUrlCardKingdomFoil) {
        this.purchaseUrlCardKingdomFoil = purchaseUrlCardKingdomFoil;
    }

    public void setPurchaseUrlCardMarket(String purchaseUrlCardMarket) {
        this.purchaseUrlCardMarket = purchaseUrlCardMarket;
    }

    public void setPurchaseUrlTcgPlayer(String purchaseUrlTcgPlayer) {
        this.purchaseUrlTcgPlayer = purchaseUrlTcgPlayer;
    }

    public void setIdentifierCardKingdomFoilId(String identifierCardKingdomFoilId) {
        this.identifierCardKingdomFoilId = identifierCardKingdomFoilId;
    }

    public void setIdentifierCardKingdomIdl(String identifierCardKingdomIdl) {
        this.identifierCardKingdomIdl = identifierCardKingdomIdl;
    }

    public void setIdentifierMcmId(String identifierMcmId) {
        this.identifierMcmId = identifierMcmId;
    }

    public void setIdentifierMcmMetaId(String identifierMcmMetaId) {
        this.identifierMcmMetaId = identifierMcmMetaId;
    }

    public void setIdentifierMtgJsonv4Id(String identifierMtgJsonv4Id) {
        this.identifierMtgJsonv4Id = identifierMtgJsonv4Id;
    }

    public void setIdentifierMtgoFoilId(String identifierMtgoFoilId) {
        this.identifierMtgoFoilId = identifierMtgoFoilId;
    }

    public void setIdentifierMtgoId(String identifierMtgoId) {
        this.identifierMtgoId = identifierMtgoId;
    }

    public void setIdentifierScryFallId(String identifierScryFallId) {
        this.identifierScryFallId = identifierScryFallId;
    }

    public void setIdentifierScryFallIllustrationId(String identifierScryFallIllustrationId) {
        this.identifierScryFallIllustrationId = identifierScryFallIllustrationId;
    }

    public void setIdentifierScryFallOracleId(String identifierScryFallOracleId) {
        this.identifierScryFallOracleId = identifierScryFallOracleId;
    }

    public void setIdentifierTcgPlayerProductId(String identifierTcgPlayerProductId) {
        this.identifierTcgPlayerProductId = identifierTcgPlayerProductId;
    }

    public void setIdentifierMultiverseID(String identifierMultiverseID) {
        this.identifierMultiverseID = identifierMultiverseID;
    }

    public void setBaseSetSize(String baseSetSize) {
        this.baseSetSize = baseSetSize;
    }

    public void setForeignGermanName(String foreignGermanName) {
        this.foreignGermanName = foreignGermanName;
    }

    public void setForeignGermanLanugage(String foreignGermanLanugage) {
        this.foreignGermanLanugage = foreignGermanLanugage;
    }

    public void setForeignGermanText(String foreignGermanText) {
        this.foreignGermanText = foreignGermanText;
    }

    public void setForeignGermanType(String foreignGermanType) {
        this.foreignGermanType = foreignGermanType;
    }

    public void setForeignSpanishName(String foreignSpanishName) {
        this.foreignSpanishName = foreignSpanishName;
    }

    public void setForeignSpanishLanguage(String foreignSpanishLanguage) {
        this.foreignSpanishLanguage = foreignSpanishLanguage;
    }

    public void setForeignSpanishText(String foreignSpanishText) {
        this.foreignSpanishText = foreignSpanishText;
    }

    public void setForeignSpanishType(String foreignSpanishType) {
        this.foreignSpanishType = foreignSpanishType;
    }

    public void setForeignFrenchName(String foreignFrenchName) {
        this.foreignFrenchName = foreignFrenchName;
    }

    public void setForeignFrenchLanugage(String foreignFrenchLanugage) {
        this.foreignFrenchLanugage = foreignFrenchLanugage;
    }

    public void setForeignFrenchText(String foreignFrenchText) {
        this.foreignFrenchText = foreignFrenchText;
    }

    public void setForeignFrenchType(String foreignFrenchType) {
        this.foreignFrenchType = foreignFrenchType;
    }

    public void setForeignItalianName(String foreignItalianName) {
        this.foreignItalianName = foreignItalianName;
    }

    public void setForeignItalianLanguage(String foreignItalianLanguage) {
        this.foreignItalianLanguage = foreignItalianLanguage;
    }

    public void setForeignItalianText(String foreignItalianText) {
        this.foreignItalianText = foreignItalianText;
    }

    public void setForeignItalianType(String foreignItalianType) {
        this.foreignItalianType = foreignItalianType;
    }

    public void setForeignJapaneseName(String foreignJapaneseName) {
        this.foreignJapaneseName = foreignJapaneseName;
    }

    public void setForeignJapaneseLanguage(String foreignJapaneseLanuage) {
        this.foreignJapaneseLanuage = foreignJapaneseLanuage;
    }

    public void setForeignJapaneseText(String foreignJapaneseText) {
        this.foreignJapaneseText = foreignJapaneseText;
    }

    public void setForeignJapaneseType(String foreignJapaneseType) {
        this.foreignJapaneseType = foreignJapaneseType;
    }

    public void setForeignKoreanName(String foreignKoreanName) {
        this.foreignKoreanName = foreignKoreanName;
    }

    public void setForeignKoreanLanguage(String foreignKoreanLanguage) {
        this.foreignKoreanLanguage = foreignKoreanLanguage;
    }

    public void setForeignKoreanText(String foreignKoreanText) {
        this.foreignKoreanText = foreignKoreanText;
    }

    public void setForeignKoreanType(String foreignKoreanType) {
        this.foreignKoreanType = foreignKoreanType;
    }

    public void setForeignPortugueseName(String foreignPortugueseName) {
        this.foreignPortugueseName = foreignPortugueseName;
    }

    public void setForeignPortugueseLanguage(String foreignPortugueseLanguage) {
        this.foreignPortugueseLanguage = foreignPortugueseLanguage;
    }

    public void setForeignPortugueseText(String foreignPortugueseText) {
        this.foreignPortugueseText = foreignPortugueseText;
    }

    public void setForeignPortugueseType(String foreignPortugueseType) {
        this.foreignPortugueseType = foreignPortugueseType;
    }

    public void setForeignRussianName(String foreignRussianName) {
        this.foreignRussianName = foreignRussianName;
    }

    public void setForeignRussianLanguage(String foreignRussianLanguage) {
        this.foreignRussianLanguage = foreignRussianLanguage;
    }

    public void setForeignRussianText(String foreignRussianText) {
        this.foreignRussianText = foreignRussianText;
    }

    public void setForeignRussianType(String foreignRussianType) {
        this.foreignRussianType = foreignRussianType;
    }

    public void setForeignChineseSimplifedName(String foreignChineseSimplifedName) {
        this.foreignChineseSimplifedName = foreignChineseSimplifedName;
    }

    public void setForeignChineseSimplifedLanguage(String foreignChineseSimplifedLanguage) {
        this.foreignChineseSimplifedLanguage = foreignChineseSimplifedLanguage;
    }

    public void setForeignChineseSimplifedText(String foreignChineseSimplifedText) {
        this.foreignChineseSimplifedText = foreignChineseSimplifedText;
    }

    public void setForeignChineseSimplifedType(String foreignChineseSimplifedType) {
        this.foreignChineseSimplifedType = foreignChineseSimplifedType;
    }

    public void setForeignChineseTraditionalName(String foreignChineseTraditionalName) {
        this.foreignChineseTraditionalName = foreignChineseTraditionalName;
    }

    public void setForeignChineseTraditionalLanguage(String foreignChineseTraditionalLanguage) {
        this.foreignChineseTraditionalLanguage = foreignChineseTraditionalLanguage;
    }

    public void setForeignChineseTraditionalText(String foreignChineseTraditionalText) {
        this.foreignChineseTraditionalText = foreignChineseTraditionalText;
    }

    public void setForeignChineseTraditionalType(String foreignChineseTraditionalType) {
        this.foreignChineseTraditionalType = foreignChineseTraditionalType;
    }
}
