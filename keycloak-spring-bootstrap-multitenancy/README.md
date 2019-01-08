# keycloak-spring-bootstrap

Bootstrap project using spring boot and keycloak

This is the minimal configuration needed to startup keycloak. A small application will be started with three endpoints,
one endpoint unsecured, other secured and one for logging out.

When making the request to the secured login, you'll be redirected to keycloak's login page. Keycloak allows whitelabeling
so do not worry too much about making a template for it.

All the information needed to manage keycloak (Ie. SSO, Social Login, User Federation, etc) may be found [here](https://www.keycloak.org/docs/latest/server_admin/index.html),  

### Docker

The project contains a docker-compose file in order to start up keycloak and postgres. They are needed in order to
start working without concerning about configuration. 

The project uses docker compose to start both services. Use the following command to start them:

```
docker-compose up -d
```

If you want to start keycloak from scratch with a language different than java you may check out the following [link](https://github.com/keycloak/keycloak-quickstarts).

### TO TEST

1. Acess "http://localhost:8081/auth/admin/master/console" (user = admin, password = password)
2. Create realm in 'Add realm' with name "archib" and import "/docker/config/archib-realm.json" file. 
3. Import file "/docker/config/archib-users-0.json" in menu "Manage/Import";
4. Now test in the terminal the commands below:

```
    > export TOKEN_BEARER=$(curl -X POST -d client_id=archib-cli -d username=archib -d password=password -d grant_type=password http://192.168.99.101:8081/auth/realms/archib/protocol/openid-connect/token  | sed 's/.*access_token":"//g' | sed 's/".*//g')
    > curl -H "Authorization: Bearer $TOKEN_BEARER" -H "realm: archib" http://localhost:8181/test
```

and test access with another realm:
```
    > export TOKEN_BEARER=$(curl -X POST -d client_id=admin-cli -d username=admin -d password=password -d grant_type=password http://192.168.99.101:8081/auth/realms/master/protocol/openid-connect/token  | sed 's/.*access_token":"//g' | sed 's/".*//g')
    > curl -H "Authorization: Bearer $TOKEN_BEARER" -H "realm: master" http://localhost:8181/test
```

5. This is possible because files "archib-keycloak.json" and "master-keycloak.json" in resources folder was added.

### External links

Bellow there are all the links containing the information that lead to the creation of this boilerplate project:

- [integrating-keycloak-4-with-spring-boot-2@jinnerbichler](https://medium.com/@jinnerbichler/integrating-keycloak-4-with-spring-boot-2-microservices-6a6579f1d121)
- [keycloak-quickstarts@keycloak](https://github.com/keycloak/keycloak-quickstarts)
- [spring-boot-keycloak-tutorial@sebastienblanc](https://github.com/sebastienblanc/spring-boot-keycloak-tutorial/)
- [easily-secure-your-spring-boot@keycloak](http://blog.keycloak.org/2017/05/easily-secure-your-spring-boot.html)
- [securing-apps-and-services-with-keycloak@redhat](https://developers.redhat.com/blog/2018/08/28/securing-apps-and-services-with-keycloak/)
- [create-a-custom-theme-for-keycloak@auscunningham](https://medium.com/@auscunningham/create-a-custom-theme-for-keycloak-8781207be604)
- [jboss/keycloak@dockerhub](https://hub.docker.com/r/jboss/keycloak/)
- [Multi Tenancy]([https://www.keycloak.org/docs/2.5/securing_apps/topics/oidc/java/multi-tenancy.html])
- [movie-app@vimalKeshu](https://github.com/vimalKeshu/movie-app)
