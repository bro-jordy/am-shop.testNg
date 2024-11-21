@regress @smoke @e2e

Feature: Checkout Shop Plus

@shopcheckout
Scenario Outline: End 2 End "<ProductID>"
    Given user access page shop plus "<ProductID>"
    When the total price should be "<Price>"
    And user click on add to cart
    Then user click on next button to address
    And user input phone number "<Phone Number>"
    And user input recipient name "<Recipient Name>"
    Then user input province "<Province>"
    And user input city "<City>"
    And user input district "<District>"
    And user input postal code "<Postal Code>"
    And user input full address "<Full Address>"
    Then user click on next button to shipping
    And user click courier button "<Courier>"
    Then user select payment MNC Bank

    Examples:
    |Price  | ProductID | Phone Number  | Recipient Name | Province         | City            | District      | Postal Code   | Full Address      | Courier               |
    |18000  |1679404    | 08111092799   | Automation Test| DKIJAKARTA       | JAKARTAPUSAT    | MENTENG       | 10340         | Automation Test   | JNEREGPromoOngkir     |
    |12000  |251542     | 08111092799   | Automation Test| JAWABARAT        | KABUPATENBEKASI | TARUMAJAYA    | 17211         | Automation Test   | JNEREGREGULAR         |
    |24000  |251536     | 08123456789   | Automation Test| JAWATIMUR        | SURABAYA        | GUBENG        | 60286         | Automation Test   | SAPEXPRESSREGREGULAR  |
    |25000  |1679319    | 08123456789   | Automation Test| JAWATENGAH       | SALATIGA        | SIDOMUKTI     | 50722         | Automation Test   | JNEREGPromoOngkir     |
    |60000  |1568407    | 08123456789   | Automation Test| BALI             | BULELENG        | BANJAR        | 81152         | Automation Test   | JNEREGPromoOngkir     |
    |30000  |1561557    | 08123456789   | Automation Test| DIYOGYAKARTA     | YOGYAKARTA      | JETIS         | 55233         | Automation Test   | JNEREGPromoOngkir     |
    |22000  |1561382    | 08123456789   | Automation Test| KALIMANTANBARAT  | PONTIANAK       | PONTIANAKKOTA | 78112         | Automation Test   | JNEREGPromoOngkir     |
    |12950  |254612     | 08123456789   | Automation Test| KALIMANTANTIMUR  | BALIKPAPAN      | BALIKPAPANKOTA| 76112         | Automation Test   | JNEREGPromoOngkir     |
    |12500  |469700     | 08123456789   | Automation Test| KALIMANTANTENGAH | PALANGKARAYA    | JEKANRAYA     | 73112         | Automation Test   | JNEREGPromoOngkir     |
    |15500  |1566988    | 08123456789   | Automation Test| BANTEN           | KOTATANGERANG   | TANGERANG     | 15117         | Automation Test   | JNEREGPromoOngkir     |
    |139900 |1681046    | 08123456789   | Automation Test| DKIJAKARTA       | JAKARTAUTARA    | CILINCING     | 14130         | Automation Test   | JNEREGPromoOngkir     |
    |9500   |1611092    | 08123456789   | Automation Test| DKIJAKARTA       | JAKARTATIMUR    | CAKUNG        | 13930         | Automation Test   | JNEREGPromoOngkir     |
    |10000  |1607545    | 08123456789   | Automation Test| DKIJAKARTA       | JAKARTABARAT    | KALIDERES     | 11830         | Automation Test   | JNEREGPromoOngkir     |
    |25200  |1348497    | 08123456789   | Automation Test| DKIJAKARTA       | JAKARTASELATAN  | TEBET         | 12840         | Automation Test   | JNEREGPromoOngkir     |
    |7600   |1680871    | 08123456789   | Automation Test| BENGKULU         | BENGKULU        | SELABAR       | 38212         | Automation Test   | JNEREGPromoOngkir     |
    |12000  |1118603    | 08123456789   | Automation Test| ACEH             | ACEHJAYA        | JAYA          | 23665         | Automation Test   | JNEREGPromoOngkir     |
