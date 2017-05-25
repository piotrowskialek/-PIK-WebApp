package edu.elka.peakadvisor.model;

import com.datastax.driver.core.DataType;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.UserDefinedType;

/**
 * Created by luksmi on 25.05.17.
 */

@UserDefinedType("Rates")
public class Rates
{
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("AED")
    private Double aED;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("AFN")
    private Double aFN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ALL")
    private Double aLL;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("AMD")
    private Double aMD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ANG")
    private Double aNG;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("AOA")
    private Double aOA;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ARS")
    private Double aRS;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("AUD")
    private Double aUD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("AWG")
    private Double aWG;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("AZN")
    private Double aZN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BAM")
    private Double bAM;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BBD")
    private Integer bBD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BDT")
    private Double bDT;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BGN")
    private Double bGN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BHD")
    private Double bHD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BIF")
    private Double bIF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BMD")
    private Integer bMD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BND")
    private Double bND;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BOB")
    private Double bOB;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BRL")
    private Double bRL;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BSD")
    private Integer bSD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BTC")
    private Double bTC;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BTN")
    private Double bTN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BWP")
    private Double bWP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BYN")
    private Double bYN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("BZD")
    private Double bZD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CAD")
    private Double cAD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CDF")
    private Double cDF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CHF")
    private Double cHF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CLF")
    private Double cLF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CLP")
    private Double cLP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CNH")
    private Double cNH;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CNY")
    private Double cNY;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("COP")
    private Double cOP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CRC")
    private Double cRC;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CUC")
    private Integer cUC;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CUP")
    private Double cUP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CVE")
    private Integer cVE;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("CZK")
    private Double cZK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("DJF")
    private Double dJF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("DKK")
    private Double dKK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("DOP")
    private Double dOP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("DZD")
    private Double dZD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("EGP")
    private Double eGP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ERN")
    private Double eRN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ETB")
    private Double eTB;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("EUR")
    private Double eUR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("FJD")
    private Double fJD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("FKP")
    private Double fKP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("GBP")
    private Double gBP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("GEL")
    private Double gEL;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("GGP")
    private Double gGP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("GHS")
    private Double gHS;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("GIP")
    private Double gIP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("GMD")
    private Double gMD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("GNF")
    private Double gNF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("GTQ")
    private Double gTQ;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("GYD")
    private Double gYD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("HKD")
    private Double hKD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("HNL")
    private Double hNL;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("HRK")
    private Double hRK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("HTG")
    private Double hTG;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("HUF")
    private Double hUF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("IDR")
    private Double iDR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ILS")
    private Double iLS;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("IMP")
    private Double iMP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("INR")
    private Double iNR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("IQD")
    private Double iQD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("IRR")
    private Double iRR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ISK")
    private Double iSK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("JEP")
    private Double jEP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("JMD")
    private Double jMD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("JOD")
    private Double jOD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("JPY")
    private Double jPY;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("KES")
    private Double kES;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("KGS")
    private Double kGS;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("KHR")
    private Double kHR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("KMF")
    private Double kMF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("KPW")
    private Double kPW;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("KRW")
    private Double kRW;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("KWD")
    private Double kWD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("KYD")
    private Double kYD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("KZT")
    private Double kZT;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("LAK")
    private Double lAK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("LBP")
    private Double lBP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("LKR")
    private Double lKR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("LRD")
    private Double lRD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("LSL")
    private Double lSL;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("LYD")
    private Double lYD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MAD")
    private Double mAD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MDL")
    private Double mDL;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MGA")
    private Double mGA;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MKD")
    private Double mKD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MMK")
    private Double mMK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MNT")
    private Double mNT;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MOP")
    private Double mOP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MRO")
    private Double mRO;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MUR")
    private Double mUR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MVR")
    private Double mVR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MWK")
    private Double mWK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MXN")
    private Double mXN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MYR")
    private Double mYR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("MZN")
    private Double mZN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("NAD")
    private Double nAD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("NGN")
    private Double nGN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("NIO")
    private Double nIO;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("NOK")
    private Double nOK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("NPR")
    private Double nPR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("NZD")
    private Double nZD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("OMR")
    private Double oMR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("PAB")
    private Integer pAB;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("PEN")
    private Double pEN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("PGK")
    private Double pGK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("PHP")
    private Double pHP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("PKR")
    private Double pKR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("PLN")
    private Double pLN;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("PYG")
    private Double pYG;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("QAR")
    private Double qAR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("RON")
    private Double rON;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("RSD")
    private Double rSD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("RUB")
    private Double rUB;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("RWF")
    private Double rWF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SAR")
    private Double sAR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SBD")
    private Double sBD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SCR")
    private Double sCR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SDG")
    private Double sDG;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SEK")
    private Double sEK;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SGD")
    private Double sGD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SHP")
    private Double sHP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SLL")
    private Double sLL;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SOS")
    private Double sOS;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SRD")
    private Double sRD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SSP")
    private Double sSP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("STD")
    private Double sTD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SVC")
    private Double sVC;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SYP")
    private Double sYP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("SZL")
    private Double sZL;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("THB")
    private Double tHB;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("TJS")
    private Double tJS;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("TMT")
    private Double tMT;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("TND")
    private Double tND;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("TOP")
    private Double tOP;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("TRY")
    private Double tRY;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("TTD")
    private Double tTD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("TWD")
    private Double tWD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("TZS")
    private Double tZS;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("UAH")
    private Double uAH;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("UGX")
    private Double uGX;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("USD")
    private Integer uSD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("UYU")
    private Double uYU;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("UZS")
    private Double uZS;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("VEF")
    private Double vEF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("VND")
    private Double vND;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("VUV")
    private Double vUV;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("WST")
    private Double wST;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("XAF")
    private Double xAF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("XAG")
    private Double xAG;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("XAU")
    private Double xAU;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("XCD")
    private Double xCD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("XDR")
    private Double xDR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("XOF")
    private Double xOF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("XPD")
    private Double xPD;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("XPF")
    private Double xPF;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("XPT")
    private Double xPT;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("YER")
    private Double yER;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ZAR")
    private Double zAR;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ZMW")
    private Double zMW;
    @CassandraType(type = DataType.Name.DOUBLE)
    @JsonProperty("ZWL")
    private Double zWL;


    @JsonProperty("AED")
    public Double getAED() {
        return aED;
    }

    @JsonProperty("AED")
    public void setAED(Double aED) {
        this.aED = aED;
    }

    @JsonProperty("AFN")
    public Double getAFN() {
        return aFN;
    }

    @JsonProperty("AFN")
    public void setAFN(Double aFN) {
        this.aFN = aFN;
    }

    @JsonProperty("ALL")
    public Double getALL() {
        return aLL;
    }

    @JsonProperty("ALL")
    public void setALL(Double aLL) {
        this.aLL = aLL;
    }

    @JsonProperty("AMD")
    public Double getAMD() {
        return aMD;
    }

    @JsonProperty("AMD")
    public void setAMD(Double aMD) {
        this.aMD = aMD;
    }

    @JsonProperty("ANG")
    public Double getANG() {
        return aNG;
    }

    @JsonProperty("ANG")
    public void setANG(Double aNG) {
        this.aNG = aNG;
    }

    @JsonProperty("AOA")
    public Double getAOA() {
        return aOA;
    }

    @JsonProperty("AOA")
    public void setAOA(Double aOA) {
        this.aOA = aOA;
    }

    @JsonProperty("ARS")
    public Double getARS() {
        return aRS;
    }

    @JsonProperty("ARS")
    public void setARS(Double aRS) {
        this.aRS = aRS;
    }

    @JsonProperty("AUD")
    public Double getAUD() {
        return aUD;
    }

    @JsonProperty("AUD")
    public void setAUD(Double aUD) {
        this.aUD = aUD;
    }

    @JsonProperty("AWG")
    public Double getAWG() {
        return aWG;
    }

    @JsonProperty("AWG")
    public void setAWG(Double aWG) {
        this.aWG = aWG;
    }

    @JsonProperty("AZN")
    public Double getAZN() {
        return aZN;
    }

    @JsonProperty("AZN")
    public void setAZN(Double aZN) {
        this.aZN = aZN;
    }

    @JsonProperty("BAM")
    public Double getBAM() {
        return bAM;
    }

    @JsonProperty("BAM")
    public void setBAM(Double bAM) {
        this.bAM = bAM;
    }

    @JsonProperty("BBD")
    public Integer getBBD() {
        return bBD;
    }

    @JsonProperty("BBD")
    public void setBBD(Integer bBD) {
        this.bBD = bBD;
    }

    @JsonProperty("BDT")
    public Double getBDT() {
        return bDT;
    }

    @JsonProperty("BDT")
    public void setBDT(Double bDT) {
        this.bDT = bDT;
    }

    @JsonProperty("BGN")
    public Double getBGN() {
        return bGN;
    }

    @JsonProperty("BGN")
    public void setBGN(Double bGN) {
        this.bGN = bGN;
    }

    @JsonProperty("BHD")
    public Double getBHD() {
        return bHD;
    }

    @JsonProperty("BHD")
    public void setBHD(Double bHD) {
        this.bHD = bHD;
    }

    @JsonProperty("BIF")
    public Double getBIF() {
        return bIF;
    }

    @JsonProperty("BIF")
    public void setBIF(Double bIF) {
        this.bIF = bIF;
    }

    @JsonProperty("BMD")
    public Integer getBMD() {
        return bMD;
    }

    @JsonProperty("BMD")
    public void setBMD(Integer bMD) {
        this.bMD = bMD;
    }

    @JsonProperty("BND")
    public Double getBND() {
        return bND;
    }

    @JsonProperty("BND")
    public void setBND(Double bND) {
        this.bND = bND;
    }

    @JsonProperty("BOB")
    public Double getBOB() {
        return bOB;
    }

    @JsonProperty("BOB")
    public void setBOB(Double bOB) {
        this.bOB = bOB;
    }

    @JsonProperty("BRL")
    public Double getBRL() {
        return bRL;
    }

    @JsonProperty("BRL")
    public void setBRL(Double bRL) {
        this.bRL = bRL;
    }

    @JsonProperty("BSD")
    public Integer getBSD() {
        return bSD;
    }

    @JsonProperty("BSD")
    public void setBSD(Integer bSD) {
        this.bSD = bSD;
    }

    @JsonProperty("BTC")
    public Double getBTC() {
        return bTC;
    }

    @JsonProperty("BTC")
    public void setBTC(Double bTC) {
        this.bTC = bTC;
    }

    @JsonProperty("BTN")
    public Double getBTN() {
        return bTN;
    }

    @JsonProperty("BTN")
    public void setBTN(Double bTN) {
        this.bTN = bTN;
    }

    @JsonProperty("BWP")
    public Double getBWP() {
        return bWP;
    }

    @JsonProperty("BWP")
    public void setBWP(Double bWP) {
        this.bWP = bWP;
    }

    @JsonProperty("BYN")
    public Double getBYN() {
        return bYN;
    }

    @JsonProperty("BYN")
    public void setBYN(Double bYN) {
        this.bYN = bYN;
    }

    @JsonProperty("BZD")
    public Double getBZD() {
        return bZD;
    }

    @JsonProperty("BZD")
    public void setBZD(Double bZD) {
        this.bZD = bZD;
    }

    @JsonProperty("CAD")
    public Double getCAD() {
        return cAD;
    }

    @JsonProperty("CAD")
    public void setCAD(Double cAD) {
        this.cAD = cAD;
    }

    @JsonProperty("CDF")
    public Double getCDF() {
        return cDF;
    }

    @JsonProperty("CDF")
    public void setCDF(Double cDF) {
        this.cDF = cDF;
    }

    @JsonProperty("CHF")
    public Double getCHF() {
        return cHF;
    }

    @JsonProperty("CHF")
    public void setCHF(Double cHF) {
        this.cHF = cHF;
    }

    @JsonProperty("CLF")
    public Double getCLF() {
        return cLF;
    }

    @JsonProperty("CLF")
    public void setCLF(Double cLF) {
        this.cLF = cLF;
    }

    @JsonProperty("CLP")
    public Double getCLP() {
        return cLP;
    }

    @JsonProperty("CLP")
    public void setCLP(Double cLP) {
        this.cLP = cLP;
    }

    @JsonProperty("CNH")
    public Double getCNH() {
        return cNH;
    }

    @JsonProperty("CNH")
    public void setCNH(Double cNH) {
        this.cNH = cNH;
    }

    @JsonProperty("CNY")
    public Double getCNY() {
        return cNY;
    }

    @JsonProperty("CNY")
    public void setCNY(Double cNY) {
        this.cNY = cNY;
    }

    @JsonProperty("COP")
    public Double getCOP() {
        return cOP;
    }

    @JsonProperty("COP")
    public void setCOP(Double cOP) {
        this.cOP = cOP;
    }

    @JsonProperty("CRC")
    public Double getCRC() {
        return cRC;
    }

    @JsonProperty("CRC")
    public void setCRC(Double cRC) {
        this.cRC = cRC;
    }

    @JsonProperty("CUC")
    public Integer getCUC() {
        return cUC;
    }

    @JsonProperty("CUC")
    public void setCUC(Integer cUC) {
        this.cUC = cUC;
    }

    @JsonProperty("CUP")
    public Double getCUP() {
        return cUP;
    }

    @JsonProperty("CUP")
    public void setCUP(Double cUP) {
        this.cUP = cUP;
    }

    @JsonProperty("CVE")
    public Integer getCVE() {
        return cVE;
    }

    @JsonProperty("CVE")
    public void setCVE(Integer cVE) {
        this.cVE = cVE;
    }

    @JsonProperty("CZK")
    public Double getCZK() {
        return cZK;
    }

    @JsonProperty("CZK")
    public void setCZK(Double cZK) {
        this.cZK = cZK;
    }

    @JsonProperty("DJF")
    public Double getDJF() {
        return dJF;
    }

    @JsonProperty("DJF")
    public void setDJF(Double dJF) {
        this.dJF = dJF;
    }

    @JsonProperty("DKK")
    public Double getDKK() {
        return dKK;
    }

    @JsonProperty("DKK")
    public void setDKK(Double dKK) {
        this.dKK = dKK;
    }

    @JsonProperty("DOP")
    public Double getDOP() {
        return dOP;
    }

    @JsonProperty("DOP")
    public void setDOP(Double dOP) {
        this.dOP = dOP;
    }

    @JsonProperty("DZD")
    public Double getDZD() {
        return dZD;
    }

    @JsonProperty("DZD")
    public void setDZD(Double dZD) {
        this.dZD = dZD;
    }

    @JsonProperty("EGP")
    public Double getEGP() {
        return eGP;
    }

    @JsonProperty("EGP")
    public void setEGP(Double eGP) {
        this.eGP = eGP;
    }

    @JsonProperty("ERN")
    public Double getERN() {
        return eRN;
    }

    @JsonProperty("ERN")
    public void setERN(Double eRN) {
        this.eRN = eRN;
    }

    @JsonProperty("ETB")
    public Double getETB() {
        return eTB;
    }

    @JsonProperty("ETB")
    public void setETB(Double eTB) {
        this.eTB = eTB;
    }

    @JsonProperty("EUR")
    public Double getEUR() {
        return eUR;
    }

    @JsonProperty("EUR")
    public void setEUR(Double eUR) {
        this.eUR = eUR;
    }

    @JsonProperty("FJD")
    public Double getFJD() {
        return fJD;
    }

    @JsonProperty("FJD")
    public void setFJD(Double fJD) {
        this.fJD = fJD;
    }

    @JsonProperty("FKP")
    public Double getFKP() {
        return fKP;
    }

    @JsonProperty("FKP")
    public void setFKP(Double fKP) {
        this.fKP = fKP;
    }

    @JsonProperty("GBP")
    public Double getGBP() {
        return gBP;
    }

    @JsonProperty("GBP")
    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

    @JsonProperty("GEL")
    public Double getGEL() {
        return gEL;
    }

    @JsonProperty("GEL")
    public void setGEL(Double gEL) {
        this.gEL = gEL;
    }

    @JsonProperty("GGP")
    public Double getGGP() {
        return gGP;
    }

    @JsonProperty("GGP")
    public void setGGP(Double gGP) {
        this.gGP = gGP;
    }

    @JsonProperty("GHS")
    public Double getGHS() {
        return gHS;
    }

    @JsonProperty("GHS")
    public void setGHS(Double gHS) {
        this.gHS = gHS;
    }

    @JsonProperty("GIP")
    public Double getGIP() {
        return gIP;
    }

    @JsonProperty("GIP")
    public void setGIP(Double gIP) {
        this.gIP = gIP;
    }

    @JsonProperty("GMD")
    public Double getGMD() {
        return gMD;
    }

    @JsonProperty("GMD")
    public void setGMD(Double gMD) {
        this.gMD = gMD;
    }

    @JsonProperty("GNF")
    public Double getGNF() {
        return gNF;
    }

    @JsonProperty("GNF")
    public void setGNF(Double gNF) {
        this.gNF = gNF;
    }

    @JsonProperty("GTQ")
    public Double getGTQ() {
        return gTQ;
    }

    @JsonProperty("GTQ")
    public void setGTQ(Double gTQ) {
        this.gTQ = gTQ;
    }

    @JsonProperty("GYD")
    public Double getGYD() {
        return gYD;
    }

    @JsonProperty("GYD")
    public void setGYD(Double gYD) {
        this.gYD = gYD;
    }

    @JsonProperty("HKD")
    public Double getHKD() {
        return hKD;
    }

    @JsonProperty("HKD")
    public void setHKD(Double hKD) {
        this.hKD = hKD;
    }

    @JsonProperty("HNL")
    public Double getHNL() {
        return hNL;
    }

    @JsonProperty("HNL")
    public void setHNL(Double hNL) {
        this.hNL = hNL;
    }

    @JsonProperty("HRK")
    public Double getHRK() {
        return hRK;
    }

    @JsonProperty("HRK")
    public void setHRK(Double hRK) {
        this.hRK = hRK;
    }

    @JsonProperty("HTG")
    public Double getHTG() {
        return hTG;
    }

    @JsonProperty("HTG")
    public void setHTG(Double hTG) {
        this.hTG = hTG;
    }

    @JsonProperty("HUF")
    public Double getHUF() {
        return hUF;
    }

    @JsonProperty("HUF")
    public void setHUF(Double hUF) {
        this.hUF = hUF;
    }

    @JsonProperty("IDR")
    public Double getIDR() {
        return iDR;
    }

    @JsonProperty("IDR")
    public void setIDR(Double iDR) {
        this.iDR = iDR;
    }

    @JsonProperty("ILS")
    public Double getILS() {
        return iLS;
    }

    @JsonProperty("ILS")
    public void setILS(Double iLS) {
        this.iLS = iLS;
    }

    @JsonProperty("IMP")
    public Double getIMP() {
        return iMP;
    }

    @JsonProperty("IMP")
    public void setIMP(Double iMP) {
        this.iMP = iMP;
    }

    @JsonProperty("INR")
    public Double getINR() {
        return iNR;
    }

    @JsonProperty("INR")
    public void setINR(Double iNR) {
        this.iNR = iNR;
    }

    @JsonProperty("IQD")
    public Double getIQD() {
        return iQD;
    }

    @JsonProperty("IQD")
    public void setIQD(Double iQD) {
        this.iQD = iQD;
    }

    @JsonProperty("IRR")
    public Double getIRR() {
        return iRR;
    }

    @JsonProperty("IRR")
    public void setIRR(Double iRR) {
        this.iRR = iRR;
    }

    @JsonProperty("ISK")
    public Double getISK() {
        return iSK;
    }

    @JsonProperty("ISK")
    public void setISK(Double iSK) {
        this.iSK = iSK;
    }

    @JsonProperty("JEP")
    public Double getJEP() {
        return jEP;
    }

    @JsonProperty("JEP")
    public void setJEP(Double jEP) {
        this.jEP = jEP;
    }

    @JsonProperty("JMD")
    public Double getJMD() {
        return jMD;
    }

    @JsonProperty("JMD")
    public void setJMD(Double jMD) {
        this.jMD = jMD;
    }

    @JsonProperty("JOD")
    public Double getJOD() {
        return jOD;
    }

    @JsonProperty("JOD")
    public void setJOD(Double jOD) {
        this.jOD = jOD;
    }

    @JsonProperty("JPY")
    public Double getJPY() {
        return jPY;
    }

    @JsonProperty("JPY")
    public void setJPY(Double jPY) {
        this.jPY = jPY;
    }

    @JsonProperty("KES")
    public Double getKES() {
        return kES;
    }

    @JsonProperty("KES")
    public void setKES(Double kES) {
        this.kES = kES;
    }

    @JsonProperty("KGS")
    public Double getKGS() {
        return kGS;
    }

    @JsonProperty("KGS")
    public void setKGS(Double kGS) {
        this.kGS = kGS;
    }

    @JsonProperty("KHR")
    public Double getKHR() {
        return kHR;
    }

    @JsonProperty("KHR")
    public void setKHR(Double kHR) {
        this.kHR = kHR;
    }

    @JsonProperty("KMF")
    public Double getKMF() {
        return kMF;
    }

    @JsonProperty("KMF")
    public void setKMF(Double kMF) {
        this.kMF = kMF;
    }

    @JsonProperty("KPW")
    public Double getKPW() {
        return kPW;
    }

    @JsonProperty("KPW")
    public void setKPW(Double kPW) {
        this.kPW = kPW;
    }

    @JsonProperty("KRW")
    public Double getKRW() {
        return kRW;
    }

    @JsonProperty("KRW")
    public void setKRW(Double kRW) {
        this.kRW = kRW;
    }

    @JsonProperty("KWD")
    public Double getKWD() {
        return kWD;
    }

    @JsonProperty("KWD")
    public void setKWD(Double kWD) {
        this.kWD = kWD;
    }

    @JsonProperty("KYD")
    public Double getKYD() {
        return kYD;
    }

    @JsonProperty("KYD")
    public void setKYD(Double kYD) {
        this.kYD = kYD;
    }

    @JsonProperty("KZT")
    public Double getKZT() {
        return kZT;
    }

    @JsonProperty("KZT")
    public void setKZT(Double kZT) {
        this.kZT = kZT;
    }

    @JsonProperty("LAK")
    public Double getLAK() {
        return lAK;
    }

    @JsonProperty("LAK")
    public void setLAK(Double lAK) {
        this.lAK = lAK;
    }

    @JsonProperty("LBP")
    public Double getLBP() {
        return lBP;
    }

    @JsonProperty("LBP")
    public void setLBP(Double lBP) {
        this.lBP = lBP;
    }

    @JsonProperty("LKR")
    public Double getLKR() {
        return lKR;
    }

    @JsonProperty("LKR")
    public void setLKR(Double lKR) {
        this.lKR = lKR;
    }

    @JsonProperty("LRD")
    public Double getLRD() {
        return lRD;
    }

    @JsonProperty("LRD")
    public void setLRD(Double lRD) {
        this.lRD = lRD;
    }

    @JsonProperty("LSL")
    public Double getLSL() {
        return lSL;
    }

    @JsonProperty("LSL")
    public void setLSL(Double lSL) {
        this.lSL = lSL;
    }

    @JsonProperty("LYD")
    public Double getLYD() {
        return lYD;
    }

    @JsonProperty("LYD")
    public void setLYD(Double lYD) {
        this.lYD = lYD;
    }

    @JsonProperty("MAD")
    public Double getMAD() {
        return mAD;
    }

    @JsonProperty("MAD")
    public void setMAD(Double mAD) {
        this.mAD = mAD;
    }

    @JsonProperty("MDL")
    public Double getMDL() {
        return mDL;
    }

    @JsonProperty("MDL")
    public void setMDL(Double mDL) {
        this.mDL = mDL;
    }

    @JsonProperty("MGA")
    public Double getMGA() {
        return mGA;
    }

    @JsonProperty("MGA")
    public void setMGA(Double mGA) {
        this.mGA = mGA;
    }

    @JsonProperty("MKD")
    public Double getMKD() {
        return mKD;
    }

    @JsonProperty("MKD")
    public void setMKD(Double mKD) {
        this.mKD = mKD;
    }

    @JsonProperty("MMK")
    public Double getMMK() {
        return mMK;
    }

    @JsonProperty("MMK")
    public void setMMK(Double mMK) {
        this.mMK = mMK;
    }

    @JsonProperty("MNT")
    public Double getMNT() {
        return mNT;
    }

    @JsonProperty("MNT")
    public void setMNT(Double mNT) {
        this.mNT = mNT;
    }

    @JsonProperty("MOP")
    public Double getMOP() {
        return mOP;
    }

    @JsonProperty("MOP")
    public void setMOP(Double mOP) {
        this.mOP = mOP;
    }

    @JsonProperty("MRO")
    public Double getMRO() {
        return mRO;
    }

    @JsonProperty("MRO")
    public void setMRO(Double mRO) {
        this.mRO = mRO;
    }

    @JsonProperty("MUR")
    public Double getMUR() {
        return mUR;
    }

    @JsonProperty("MUR")
    public void setMUR(Double mUR) {
        this.mUR = mUR;
    }

    @JsonProperty("MVR")
    public Double getMVR() {
        return mVR;
    }

    @JsonProperty("MVR")
    public void setMVR(Double mVR) {
        this.mVR = mVR;
    }

    @JsonProperty("MWK")
    public Double getMWK() {
        return mWK;
    }

    @JsonProperty("MWK")
    public void setMWK(Double mWK) {
        this.mWK = mWK;
    }

    @JsonProperty("MXN")
    public Double getMXN() {
        return mXN;
    }

    @JsonProperty("MXN")
    public void setMXN(Double mXN) {
        this.mXN = mXN;
    }

    @JsonProperty("MYR")
    public Double getMYR() {
        return mYR;
    }

    @JsonProperty("MYR")
    public void setMYR(Double mYR) {
        this.mYR = mYR;
    }

    @JsonProperty("MZN")
    public Double getMZN() {
        return mZN;
    }

    @JsonProperty("MZN")
    public void setMZN(Double mZN) {
        this.mZN = mZN;
    }

    @JsonProperty("NAD")
    public Double getNAD() {
        return nAD;
    }

    @JsonProperty("NAD")
    public void setNAD(Double nAD) {
        this.nAD = nAD;
    }

    @JsonProperty("NGN")
    public Double getNGN() {
        return nGN;
    }

    @JsonProperty("NGN")
    public void setNGN(Double nGN) {
        this.nGN = nGN;
    }

    @JsonProperty("NIO")
    public Double getNIO() {
        return nIO;
    }

    @JsonProperty("NIO")
    public void setNIO(Double nIO) {
        this.nIO = nIO;
    }

    @JsonProperty("NOK")
    public Double getNOK() {
        return nOK;
    }

    @JsonProperty("NOK")
    public void setNOK(Double nOK) {
        this.nOK = nOK;
    }

    @JsonProperty("NPR")
    public Double getNPR() {
        return nPR;
    }

    @JsonProperty("NPR")
    public void setNPR(Double nPR) {
        this.nPR = nPR;
    }

    @JsonProperty("NZD")
    public Double getNZD() {
        return nZD;
    }

    @JsonProperty("NZD")
    public void setNZD(Double nZD) {
        this.nZD = nZD;
    }

    @JsonProperty("OMR")
    public Double getOMR() {
        return oMR;
    }

    @JsonProperty("OMR")
    public void setOMR(Double oMR) {
        this.oMR = oMR;
    }

    @JsonProperty("PAB")
    public Integer getPAB() {
        return pAB;
    }

    @JsonProperty("PAB")
    public void setPAB(Integer pAB) {
        this.pAB = pAB;
    }

    @JsonProperty("PEN")
    public Double getPEN() {
        return pEN;
    }

    @JsonProperty("PEN")
    public void setPEN(Double pEN) {
        this.pEN = pEN;
    }

    @JsonProperty("PGK")
    public Double getPGK() {
        return pGK;
    }

    @JsonProperty("PGK")
    public void setPGK(Double pGK) {
        this.pGK = pGK;
    }

    @JsonProperty("PHP")
    public Double getPHP() {
        return pHP;
    }

    @JsonProperty("PHP")
    public void setPHP(Double pHP) {
        this.pHP = pHP;
    }

    @JsonProperty("PKR")
    public Double getPKR() {
        return pKR;
    }

    @JsonProperty("PKR")
    public void setPKR(Double pKR) {
        this.pKR = pKR;
    }

    @JsonProperty("PLN")
    public Double getPLN() {
        return pLN;
    }

    @JsonProperty("PLN")
    public void setPLN(Double pLN) {
        this.pLN = pLN;
    }

    @JsonProperty("PYG")
    public Double getPYG() {
        return pYG;
    }

    @JsonProperty("PYG")
    public void setPYG(Double pYG) {
        this.pYG = pYG;
    }

    @JsonProperty("QAR")
    public Double getQAR() {
        return qAR;
    }

    @JsonProperty("QAR")
    public void setQAR(Double qAR) {
        this.qAR = qAR;
    }

    @JsonProperty("RON")
    public Double getRON() {
        return rON;
    }

    @JsonProperty("RON")
    public void setRON(Double rON) {
        this.rON = rON;
    }

    @JsonProperty("RSD")
    public Double getRSD() {
        return rSD;
    }

    @JsonProperty("RSD")
    public void setRSD(Double rSD) {
        this.rSD = rSD;
    }

    @JsonProperty("RUB")
    public Double getRUB() {
        return rUB;
    }

    @JsonProperty("RUB")
    public void setRUB(Double rUB) {
        this.rUB = rUB;
    }

    @JsonProperty("RWF")
    public Double getRWF() {
        return rWF;
    }

    @JsonProperty("RWF")
    public void setRWF(Double rWF) {
        this.rWF = rWF;
    }

    @JsonProperty("SAR")
    public Double getSAR() {
        return sAR;
    }

    @JsonProperty("SAR")
    public void setSAR(Double sAR) {
        this.sAR = sAR;
    }

    @JsonProperty("SBD")
    public Double getSBD() {
        return sBD;
    }

    @JsonProperty("SBD")
    public void setSBD(Double sBD) {
        this.sBD = sBD;
    }

    @JsonProperty("SCR")
    public Double getSCR() {
        return sCR;
    }

    @JsonProperty("SCR")
    public void setSCR(Double sCR) {
        this.sCR = sCR;
    }

    @JsonProperty("SDG")
    public Double getSDG() {
        return sDG;
    }

    @JsonProperty("SDG")
    public void setSDG(Double sDG) {
        this.sDG = sDG;
    }

    @JsonProperty("SEK")
    public Double getSEK() {
        return sEK;
    }

    @JsonProperty("SEK")
    public void setSEK(Double sEK) {
        this.sEK = sEK;
    }

    @JsonProperty("SGD")
    public Double getSGD() {
        return sGD;
    }

    @JsonProperty("SGD")
    public void setSGD(Double sGD) {
        this.sGD = sGD;
    }

    @JsonProperty("SHP")
    public Double getSHP() {
        return sHP;
    }

    @JsonProperty("SHP")
    public void setSHP(Double sHP) {
        this.sHP = sHP;
    }

    @JsonProperty("SLL")
    public Double getSLL() {
        return sLL;
    }

    @JsonProperty("SLL")
    public void setSLL(Double sLL) {
        this.sLL = sLL;
    }

    @JsonProperty("SOS")
    public Double getSOS() {
        return sOS;
    }

    @JsonProperty("SOS")
    public void setSOS(Double sOS) {
        this.sOS = sOS;
    }

    @JsonProperty("SRD")
    public Double getSRD() {
        return sRD;
    }

    @JsonProperty("SRD")
    public void setSRD(Double sRD) {
        this.sRD = sRD;
    }

    @JsonProperty("SSP")
    public Double getSSP() {
        return sSP;
    }

    @JsonProperty("SSP")
    public void setSSP(Double sSP) {
        this.sSP = sSP;
    }

    @JsonProperty("STD")
    public Double getSTD() {
        return sTD;
    }

    @JsonProperty("STD")
    public void setSTD(Double sTD) {
        this.sTD = sTD;
    }

    @JsonProperty("SVC")
    public Double getSVC() {
        return sVC;
    }

    @JsonProperty("SVC")
    public void setSVC(Double sVC) {
        this.sVC = sVC;
    }

    @JsonProperty("SYP")
    public Double getSYP() {
        return sYP;
    }

    @JsonProperty("SYP")
    public void setSYP(Double sYP) {
        this.sYP = sYP;
    }

    @JsonProperty("SZL")
    public Double getSZL() {
        return sZL;
    }

    @JsonProperty("SZL")
    public void setSZL(Double sZL) {
        this.sZL = sZL;
    }

    @JsonProperty("THB")
    public Double getTHB() {
        return tHB;
    }

    @JsonProperty("THB")
    public void setTHB(Double tHB) {
        this.tHB = tHB;
    }

    @JsonProperty("TJS")
    public Double getTJS() {
        return tJS;
    }

    @JsonProperty("TJS")
    public void setTJS(Double tJS) {
        this.tJS = tJS;
    }

    @JsonProperty("TMT")
    public Double getTMT() {
        return tMT;
    }

    @JsonProperty("TMT")
    public void setTMT(Double tMT) {
        this.tMT = tMT;
    }

    @JsonProperty("TND")
    public Double getTND() {
        return tND;
    }

    @JsonProperty("TND")
    public void setTND(Double tND) {
        this.tND = tND;
    }

    @JsonProperty("TOP")
    public Double getTOP() {
        return tOP;
    }

    @JsonProperty("TOP")
    public void setTOP(Double tOP) {
        this.tOP = tOP;
    }

    @JsonProperty("TRY")
    public Double getTRY() {
        return tRY;
    }

    @JsonProperty("TRY")
    public void setTRY(Double tRY) {
        this.tRY = tRY;
    }

    @JsonProperty("TTD")
    public Double getTTD() {
        return tTD;
    }

    @JsonProperty("TTD")
    public void setTTD(Double tTD) {
        this.tTD = tTD;
    }

    @JsonProperty("TWD")
    public Double getTWD() {
        return tWD;
    }

    @JsonProperty("TWD")
    public void setTWD(Double tWD) {
        this.tWD = tWD;
    }

    @JsonProperty("TZS")
    public Double getTZS() {
        return tZS;
    }

    @JsonProperty("TZS")
    public void setTZS(Double tZS) {
        this.tZS = tZS;
    }

    @JsonProperty("UAH")
    public Double getUAH() {
        return uAH;
    }

    @JsonProperty("UAH")
    public void setUAH(Double uAH) {
        this.uAH = uAH;
    }

    @JsonProperty("UGX")
    public Double getUGX() {
        return uGX;
    }

    @JsonProperty("UGX")
    public void setUGX(Double uGX) {
        this.uGX = uGX;
    }

    @JsonProperty("USD")
    public Integer getUSD() {
        return uSD;
    }

    @JsonProperty("USD")
    public void setUSD(Integer uSD) {
        this.uSD = uSD;
    }

    @JsonProperty("UYU")
    public Double getUYU() {
        return uYU;
    }

    @JsonProperty("UYU")
    public void setUYU(Double uYU) {
        this.uYU = uYU;
    }

    @JsonProperty("UZS")
    public Double getUZS() {
        return uZS;
    }

    @JsonProperty("UZS")
    public void setUZS(Double uZS) {
        this.uZS = uZS;
    }

    @JsonProperty("VEF")
    public Double getVEF() {
        return vEF;
    }

    @JsonProperty("VEF")
    public void setVEF(Double vEF) {
        this.vEF = vEF;
    }

    @JsonProperty("VND")
    public Double getVND() {
        return vND;
    }

    @JsonProperty("VND")
    public void setVND(Double vND) {
        this.vND = vND;
    }

    @JsonProperty("VUV")
    public Double getVUV() {
        return vUV;
    }

    @JsonProperty("VUV")
    public void setVUV(Double vUV) {
        this.vUV = vUV;
    }

    @JsonProperty("WST")
    public Double getWST() {
        return wST;
    }

    @JsonProperty("WST")
    public void setWST(Double wST) {
        this.wST = wST;
    }

    @JsonProperty("XAF")
    public Double getXAF() {
        return xAF;
    }

    @JsonProperty("XAF")
    public void setXAF(Double xAF) {
        this.xAF = xAF;
    }

    @JsonProperty("XAG")
    public Double getXAG() {
        return xAG;
    }

    @JsonProperty("XAG")
    public void setXAG(Double xAG) {
        this.xAG = xAG;
    }

    @JsonProperty("XAU")
    public Double getXAU() {
        return xAU;
    }

    @JsonProperty("XAU")
    public void setXAU(Double xAU) {
        this.xAU = xAU;
    }

    @JsonProperty("XCD")
    public Double getXCD() {
        return xCD;
    }

    @JsonProperty("XCD")
    public void setXCD(Double xCD) {
        this.xCD = xCD;
    }

    @JsonProperty("XDR")
    public Double getXDR() {
        return xDR;
    }

    @JsonProperty("XDR")
    public void setXDR(Double xDR) {
        this.xDR = xDR;
    }

    @JsonProperty("XOF")
    public Double getXOF() {
        return xOF;
    }

    @JsonProperty("XOF")
    public void setXOF(Double xOF) {
        this.xOF = xOF;
    }

    @JsonProperty("XPD")
    public Double getXPD() {
        return xPD;
    }

    @JsonProperty("XPD")
    public void setXPD(Double xPD) {
        this.xPD = xPD;
    }

    @JsonProperty("XPF")
    public Double getXPF() {
        return xPF;
    }

    @JsonProperty("XPF")
    public void setXPF(Double xPF) {
        this.xPF = xPF;
    }

    @JsonProperty("XPT")
    public Double getXPT() {
        return xPT;
    }

    @JsonProperty("XPT")
    public void setXPT(Double xPT) {
        this.xPT = xPT;
    }

    @JsonProperty("YER")
    public Double getYER() {
        return yER;
    }

    @JsonProperty("YER")
    public void setYER(Double yER) {
        this.yER = yER;
    }

    @JsonProperty("ZAR")
    public Double getZAR() {
        return zAR;
    }

    @JsonProperty("ZAR")
    public void setZAR(Double zAR) {
        this.zAR = zAR;
    }

    @JsonProperty("ZMW")
    public Double getZMW() {
        return zMW;
    }

    @JsonProperty("ZMW")
    public void setZMW(Double zMW) {
        this.zMW = zMW;
    }

    @JsonProperty("ZWL")
    public Double getZWL() {
        return zWL;
    }

    @JsonProperty("ZWL")
    public void setZWL(Double zWL) {
        this.zWL = zWL;
    }

}