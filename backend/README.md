## Backend
___
### This app contains three modules:
* admin
* config
* application
___
> For successful run lunch the modules in the **_config_** module before the main **_application_** 
___
> For proper build of your application you need to create environmental variable **JASYPT_PASS** 
> and as the value use you jasypt encrypt/decrypt password
> 
> For proper run add into **run/debug configuration**: -Djasypt.encryptor.password=yourPassword 
> -Djasypt.plugin.path="file:path to file to decrypt"