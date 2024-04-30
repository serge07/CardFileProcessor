//package Serge.Card.File.Reader;
//
//import java.util.ArrayList;
//import java.io.*;
//import java.util.Collections;
//
//public class Bkp_SortedCard {
//    public static void main(String[] args) {
//        ArrayList<Card> cardRecords = new ArrayList<>();
//        String currentLine = "";
//        String source = "/Users/serge/Library/CloudStorage/ProtonDrive-amosbiko@protonmail.com/WORK DOCS/Card File Reader/cardInput.txt";
//        String destination = "/Users/serge/Library/CloudStorage/ProtonDrive-amosbiko@protonmail.com/WORK DOCS/Card File Reader/cardOutput.txt";
//
//        String header = "";
//        String footer = "";
//        try (BufferedReader reader = new BufferedReader(new FileReader(source));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
//            //skip header
//            header = reader.readLine();
//
//            while ((currentLine = reader.readLine()) != null) {
//                //Trimming any leading or trailing whitespace from the read line
//                currentLine = currentLine.trim();
//
//                //Checking if the line is empty or starts with "<trailer>" to skip such lines
//                if (currentLine.isEmpty()) {
//                    continue;
//                }
//                if (currentLine.startsWith("<Trailer>")) {
//                    footer = currentLine;
//                    break;
//                }
//                //Reading the body of the line
//                String[] cardDetail = currentLine.split(",");
//                long pan = Long.parseLong(cardDetail[0]);
//                String sequenceNumber = cardDetail[1];
//                String fromDate = cardDetail[2];
//                String fromDay = cardDetail[3];
//                String expiryDate = cardDetail[4];
//                String expiryDay = cardDetail[5];
//                String cardholderName = cardDetail[6];
//                String cardholderTitle = cardDetail[7];
//                String cardholderFirstName = cardDetail[8];
//                String cardholderInitials = cardDetail[9];
//                String cardholderLastName = cardDetail[10];
//                String customerID = cardDetail[11];
//                int issuerReference = Integer.parseInt(cardDetail[12]);
//                String companyName = cardDetail[13];
//                String cardType = cardDetail[14];
//                int cvv = Integer.parseInt(cardDetail[15]);
//                int cvv2 = Integer.parseInt(cardDetail[16]);
//                String generateSecurePIN = cardDetail[17];
//                String securePINOffset = cardDetail[18];
//                String securePINBlock = cardDetail[19];
//                String generateInsecurePIN = cardDetail[20];
//                String insecurePINOffset = cardDetail[21];
//                String insecurePINBlock = cardDetail[22];
//                String produceCard = cardDetail[23];
//                String produceCardMailer = cardDetail[24];
//                String producePINMailer = cardDetail[25];
//                String track2Data = cardDetail[26];
//                String cardMailerAddress1 = cardDetail[27];
//                String cardMailerAddress2 = cardDetail[28];
//                String cardMailerAddressCity = cardDetail[29];
//                String cardMailerAddressRegion = cardDetail[30];
//                String cardMailerAddressPostalCode = cardDetail[31];
//                String pinMailerAddress1 = cardDetail[32];
//                String pinMailerAddress2 = cardDetail[33];
//                String pinMailerAddressCity = cardDetail[34];
//                String pinMailerAddressRegion = cardDetail[35];
//                String pinMailerAddressPostalCode = cardDetail[36];
//                String cardCustomState = cardDetail[37];
//                String securePINLength = cardDetail[38];
//                String insecurePINLength = cardDetail[39];
//                String cardholderInfo = cardDetail[40];
//                int branchCode = Integer.parseInt(cardDetail[41]);
//                String dateIssued = cardDetail[42];
//                String batchNumber = cardDetail[43];
//                String nationalID = cardDetail[44];
//                String telephoneNr = cardDetail[45];
//                String mobileNr = cardDetail[46];
//                String fax = cardDetail[47];
//                String emailAddress = cardDetail[48];
//                String address1 = cardDetail[49];
//                String address2 = cardDetail[50];
//                String city = cardDetail[51];
//                String region = cardDetail[52];
//                String postalCode = cardDetail[53];
//                String country = cardDetail[54];
//                String dateOfBirth = cardDetail[55];
//                String preferredLang = cardDetail[56];
//                String extendedCard = cardDetail[57];
//                String extendedCustomer = cardDetail[58];
//                String defaultAccountType = cardDetail[59];
//                String account = cardDetail[60];
//                String accountType = cardDetail[61];
//                String accountProduct = cardDetail[62];
//                String extendedAccount = cardDetail[63];
//                int iCVV = Integer.parseInt(cardDetail[64]);
//                int iCVV2 = Integer.parseInt(cardDetail[65]);
//                String csc3 = cardDetail[66];
//                String scs4 = cardDetail[67];
//                String csc5 = cardDetail[68];
//                String icsc3 = cardDetail[69];
//                String icsc4 = cardDetail[70];
//                String icsc5 = cardDetail[71];
//                String iCSC5EMVContact = cardDetail[72];
//                String iCSC5EMVContactless = cardDetail[73];
//                String iCSC5FallbackMagstripe = cardDetail[74];
//
//                cardRecords.add(new Card(pan, sequenceNumber, fromDate, fromDay, expiryDate, expiryDay, cardholderName,
//                        cardholderTitle, cardholderFirstName, cardholderInitials, cardholderLastName, customerID,
//                        issuerReference, companyName, cardType, cvv, cvv2, generateSecurePIN, securePINOffset,
//                        securePINBlock, generateInsecurePIN, insecurePINOffset, insecurePINBlock, produceCard,
//                        produceCardMailer, producePINMailer, track2Data, cardMailerAddress1, cardMailerAddress2,
//                        cardMailerAddressCity, cardMailerAddressRegion, cardMailerAddressPostalCode, pinMailerAddress1,
//                        pinMailerAddress2, pinMailerAddressCity, pinMailerAddressRegion, pinMailerAddressPostalCode,
//                        cardCustomState, securePINLength, insecurePINLength, cardholderInfo, branchCode, dateIssued,
//                        batchNumber, nationalID, telephoneNr, mobileNr, fax, emailAddress, address1, address2, city,
//                        region, postalCode, country, dateOfBirth, preferredLang, extendedCard, extendedCustomer,
//                        defaultAccountType, account, accountType, accountProduct, extendedAccount, iCVV, iCVV2, csc3,
//                        scs4, csc5, icsc3, icsc4, icsc5, iCSC5EMVContact, iCSC5EMVContactless, iCSC5FallbackMagstripe));
//
//            }
//
//            Collections.sort(cardRecords, new BranchCompare());
//            writer.write(header);
//            writer.newLine();
//            for (Card card : cardRecords) {
//                writer.write(card.pan + "," + card.sequenceNumber + "," + card.fromDate + "," + card.fromDay
//                        + "," + card.expiryDate + "," + card.expiryDay + "," + card.cardholderName + "," + card.cardholderTitle
//                        + "," + card.cardholderFirstName + "," + card.cardholderInitials + "," + card.cardholderLastName
//                        + "," + card.customerID + "," + card.issuerReference + "," + card.companyName + "," + card.cardType
//                        + "," + card.cvv + "," + card.cvv2 + "," + card.generateSecurePIN + "," + card.securePINOffset
//                        + "," + card.securePINBlock + "," + card.generateInsecurePIN + "," + card.insecurePINOffset
//                        + "," + card.insecurePINBlock + "," + card.produceCard + "," + card.produceCardMailer
//                        + "," + card.producePINMailer + "," + card.track2Data + "," + card.cardMailerAddress1
//                        + "," + card.cardMailerAddress2 + "," + card.cardMailerAddressCity + "," + card.cardMailerAddressRegion
//                        + "," + card.cardMailerAddressPostalCode + "," + card.pinMailerAddress1 + "," + card.pinMailerAddress2
//                        + "," + card.pinMailerAddressCity + "," + card.pinMailerAddressRegion + "," + card.pinMailerAddressPostalCode
//                        + "," + card.cardCustomState + "," + card.securePINLength + "," + card.insecurePINLength + "," + card.cardholderInfo
//                        + "," + card.branchCode + "," + card.dateIssued + "," + card.batchNumber + "," + card.nationalID
//                        + "," + card.telephoneNr + "," + card.mobileNr + "," + card.fax + "," + card.emailAddress
//                        + "," + card.address1 + "," + card.address2 + "," + card.city + "," + card.region + "," + card.postalCode
//                        + "," + card.country + "," + card.dateOfBirth + "," + card.preferredLang + "," + card.extendedCard
//                        + "," + card.extendedCustomer + "," + card.defaultAccountType + "," + card.account + "," + card.accountType
//                        + "," + card.accountProduct + "," + card.extendedAccount + "," + card.iCVV + "," + card.iCVV2
//                        + "," + card.csc3 + "," + card.scs4 + "," + card.csc5 + "," + card.icsc3 + "," + card.icsc4
//                        + "," + card.icsc5 + "," + card.iCSC5EMVContact + "," + card.iCSC5EMVContactless + "," + card.iCSC5FallbackMagstripe);
//                writer.newLine();
//            }
//            writer.write(footer);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
