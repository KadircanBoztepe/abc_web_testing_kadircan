# LoginPage Spec

 |browsers   |
 |-----------|
 |chrome     |

## Gecerli Kullanici Adi Ve Gecerli Sifre Ile Basarili Login Olma
tags: Login
* Login with id "kadircan.boztepe", passoword "kdrcnbztp58", and browsers <browsers>
* "home_page_icon" element is Displayed

## Gecerli Kullanici Adi Ve Gecersiz Sifre Ile Hatali Login Olma
tags: Login
* Login with id "kadircan.boztepe", passoword "kdrcnbztp5888", and browsers <browsers>
* The text of the "login_page_invalid_message" element assert "Username or Password Invalid!"

## Gecersiz Kullanici Adi Ve Gecerli Sifre Ile Hatali Login Olma
tags: Login
* Login with id "kadircan.boztepe58", passoword "kdrcnbztp58", and browsers <browsers>
* The text of the "login_page_invalid_message" element assert "Username or Password Invalid!"

## Gecersiz Kullanici Adi Ve Gecersiz Sifre Ile Hatali Login Olma
tags: Login
* Login with id "kadircan.boztepe58", passoword "kdrcnbztp5888", and browsers <browsers>
* The text of the "login_page_invalid_message" element assert "Username or Password Invalid!"

## Bos Kullanici Adi Ve Gecerli Sifre Ile Hatali Login Olma
tags: Login
* Login with id "", passoword "kdrcnbztp58", and browsers <browsers>
* The text of the "login_page_invalid_message" element assert "Username or Password Invalid!"


## Gecerli Kullanici Adi Ve Bos Sifre Ile Hatali Login Olma
tags: Login
* Login with id "kadircan.boztepe", passoword "", and browsers <browsers>
* The text of the "login_page_invalid_message" element assert "Username or Password Invalid!"

## Bos Kullanici Adi Ve Bos Sifre Ile Hatali Login Olma
tags: Login
* Login with id "", passoword "", and browsers <browsers>
* The text of the "login_page_invalid_message" element assert "Username or Password Invalid!"
