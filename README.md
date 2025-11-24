 # titre: "TP WebService Étudiant – PHP / MySQL / Android"
  
 ## Introduction: |
    Ce projet a été réalisé dans le cadre d’un TP portant sur la création,
    le test et l’intégration d’un WebService permettant la gestion des étudiants.
    Le travail se divise en deux grandes parties :
    1) Développement d’un WebService avec PHP et MySQL (CRUD complet)
    2) Création d’une application Android consommant ces WebServices.

 ## Objectifs_du_TP: |
    - Comprendre la création d’un WebService en PHP.
    - Mettre en place un accès aux données via un modèle DAO.
    - Tester les endpoints à l’aide de Postman.
    - Implémenter une architecture client mobile consommant ces services.
    - Effectuer des opérations CRUD (Ajouter, Afficher, Modifier, Supprimer).
    - Configurer Android pour supporter le ClearText HTTP.
    - Utiliser une adresse IP locale afin de communiquer entre mobile et serveur.

 ## Technologies_Utilisées:
   ### Backend:
      - PHP 8
      - MySQL / phpMyAdmin
      - Serveur Apache (XAMPP)
      - Modèle DAO (Data Access Object)
   ### Tests:
      - Postman (Test API)
      - Navigateur (Validation JSON)
   ###  Mobile:
      - Android Studio (Java)
      - Volley (Librairie HTTP)
      - Manifest + Cleartext Traffic
   ###  Réseau:
      - WiFi Local commun entre PC et smartphone
      - IP du PC (exemple: 192.168.1.6)

  ### Structure_du_Projet:
    Côté_WebService: |
    <img width="296" height="385" alt="image" src="https://github.com/user-attachments/assets/189043a8-f93e-45a4-9972-dc8650db8176" />

   ### Côté_Android: |
    <img width="456" height="792" alt="image" src="https://github.com/user-attachments/assets/406601fd-3442-46a9-950b-3f1c6a56227f" />

   ### Base_de_Données:
  ### Description: |
      Une base de données MySQL contenant une seule table "etudiant".
      Elle stocke les informations nécessaires pour les opérations CRUD.
  ### Table_etudiant:
      colonnes:
        - id: INT AUTO_INCREMENT PRIMARY KEY
        - nom: VARCHAR(50)
        - prenom: VARCHAR(50)
        - ville: VARCHAR(50)
        - sexe: VARCHAR(10)
<img width="1889" height="412" alt="image" src="https://github.com/user-attachments/assets/39114585-7d14-4a3c-880b-7f76d0f60ce2" />

  ### WebService_PHP:
 ### Organisation: |
      Tous les services se trouvent dans le dossier "ws".
      Chaque fichier représente une opération CRUD.
      L’accès MySQL est centralisé dans le fichier DAO.
 ### Liste_des_fichiers:
      - addEtudiant.php : Ajout d’un étudiant (méthode POST)
      - loadEtudiant.php : Chargement de la liste (méthode GET)
      - updateEtudiant.php : Mise à jour (POST)
      - deleteEtudiant.php : Suppression (POST)

  ### Tests_Postman:
    Description: |
      Avant l’intégration dans Android, chaque WebService a été testé via Postman.
      Les requêtes ont été configurées en utilisant l’URL locale du serveur Apache.
    Endpoints:
      - POST /addEtudiant.php
      - GET  /loadEtudiant.php
      - POST /updateEtudiant.php
      - POST /deleteEtudiant.php
    Exemple_de_corps_POST:
      - nom: "Test"
      - prenom: "User"
      - ville: "Rabat"
      - sexe: "Homme"
  <img width="1576" height="934" alt="get lab8" src="https://github.com/user-attachments/assets/0b157712-6b82-4c75-81f0-0aaad66b1043" />
  <img width="1054" height="881" alt="post lab8" src="https://github.com/user-attachments/assets/d9124968-22b2-4036-bd60-8e63cbcb130a" />
  ### Application_Android:
 ### Description: |
      L’application Android consomme les WebServices via la bibliothèque Volley.
      Elle comporte deux écrans principaux :
        1) Ajout d’un étudiant
        2) Affichage de la liste des étudiants
      Le téléphone doit obligatoirement être connecté au même réseau WiFi que le PC.
 ### URLs_utilisées:
      - "http://192.168.1.6/WebServiceEtudiant/ws/addEtudiant.php"
      - "http://192.168.1.6/WebServiceEtudiant/ws/loadEtudiant.php"

  ## Configuration_Réseau_Android:
 ### Explication: |
      Android bloque les connexions HTTP non sécurisées (HTTP au lieu de HTTPS).
      Il faut donc activer explicitement le ClearText.
   ### Manifest:
      - usesCleartextTraffic: true
      - networkSecurityConfig: "@xml/network_security_config"
    network_security_config:
      domaine_autorisé: "192.168.1.6"

  ## Tests_Final_Android:
    Ajout: |
      Remplir le formulaire → Cliquer sur ADD → Message de succès affiché.
    Liste: |
      Cliquer sur “Afficher” → Les étudiants apparaissent sous forme de liste.
 ##   Capteur d'ecron:
![WhatsApp Image 2025-11-24 at 23 42 38](https://github.com/user-attachments/assets/8bc6c67c-3d53-458b-9629-b0af122ba6c1)
![WhatsApp Image 2025-11-24 at 23 42 36](https://github.com/user-attachments/assets/5428bb14-68c6-4a57-adfe-ed10b29b044c)
![WhatsApp Image 2025-11-24 at 23 42 38 (1)](https://github.com/user-attachments/assets/1a6d8793-ce38-4ac0-a9a7-ccca18de5ca0)
<img width="1201" height="549" alt="image" src="https://github.com/user-attachments/assets/4da0e4b0-c4b5-462f-8ac6-322c65146224" />


  ## Notes_Importantes: |
    - Le téléphone et le PC doivent être sur le même réseau WiFi.
    - L’adresse utilisée doit être l’IP locale du PC.
    - 10.0.2.2 fonctionne uniquement pour l’émulateur Android.
    - Toujours activer le ClearText pour tester en HTTP.
    - Redémarrer Apache/XAMPP après chaque changement important.
