# MowItNow - Tondeuse Automatique

## Description
Ce projet implémente une tondeuse à gazon automatique pour la société MowItNow.

La tondeuse est conçue pour :
- Parcourir une pelouse rectangulaire
- Ne dépasser les limites.

La tondeuse peut être positionnée sur la grille en utilisant des coordonnées `(x, y)` et une orientation cardinale (`N`, `E`, `W`, `S`). Elle accepte les commandes suivantes :
- `D` : Pivote de 90° à droite
- `G` : Pivote de 90° à gauche
- `A` : Avance d'une case dans la direction actuelle

## Structure du Fichier d'Entrée
Le programme prend un fichier d'entrée structuré ainsi :
1. La première ligne contient les coordonnées du coin supérieur droit de la pelouse.
2. Chaque tondeuse est ensuite définie par deux lignes :
    - Une ligne de position initiale et d'orientation (`x y orientation`).
    - Une ligne de commandes (par exemple : `GAGAGAGAA


## User Stories:
### US 1: Définir la surface de la pelouse:
- `En tant` qu'utilisateur de la tondeuse,
- `je veux` définir la taille de la pelouse en entrant les coordonnées de son coin supérieur droit,
- `afin` que la tondeuse sache jusqu’où elle peut se déplacer sans sortir des limites.

#### Critères d'acceptation :
- Les coordonnées du coin supérieur droit de la pelouse on des valeurs positif.

### US 2 - Initialiser la position et l'orientation de la tondeuse
- `En tant` qu'utilisateur de la tondeuse,
- `je veux` indiquer la position initiale et l'orientation de la tondeuse,
- `afin` que je puisse spécifier d’où elle commence son parcours.

#### Critères d'acceptation :
- La position inital toi être dans la surface de la pelouse
- la direction doit être parmis: N, E, W, S

### US 3 - Définir une séquence de commandes pour la tondeuse
- `En tant` qu'utilisateur de la tondeuse,
- `je veux` pouvoir entrer une séquence de commandes pour la tondeuse,
- `afin` que celle-ci puisse se déplacer et explorer la pelouse selon mes instructions.

#### Critères d'acceptation :
- Les commandes doivent être limitées aux lettres G, D, et A.
- La tondeuse doit exécuter chaque commande dans l'ordre.
- G et D tournent la tondeuse de 90° respectivement à gauche et à droite sans changer sa position.
- A fait avancer la tondeuse d'une case dans la direction où elle est orientée.

### US 4 - Empêcher la tondeuse de sortir de la pelouse
- `En tant` qu'utilisateur de la tondeuse,
- `je veux` que la tondeuse respecte les limites de la pelouse,
- `afin` que celle-ci ne sorte pas de la surface définie.

#### Critères d'acceptation :
- Si la tondeuse reçoit une commande qui la placerait en dehors de la pelouse, elle ignore cette commande et conserve sa position et orientation actuelles.

### US 5 - Traiter plusieurs tondeuses
- `En tant` qu'utilisateur de la tondeuse,
- `je veux`  pouvoir déployer et contrôler plusieurs tondeuses sur la même pelouse,
- `afin` que chaque tondeuse puisse explorer différentes parties de la pelouse sans se déplacer en même temps.

#### Critères d'acceptation :
- Chaque tondeuse reçoit une position initiale, une orientation, et une séquence de commandes.
- Les tondeuses exécutent leurs commandes séquentiellement, une à la fois.
- Une tondeuse ne commence à bouger que lorsque la précédente a terminé.

### US 6 - Obtenir la position finale des tondeuses
- `En tant` qu'utilisateur de la tondeuse,
- `je veux`  pouvoir connaître la position finale de chaque tondeuse après l’exécution de toutes les commandes,
- `afin` que je sache où chacune d'elles s'est arrêtée et dans quelle orientation.

#### Critères d'acceptation :
- La position et l'orientation finales de chaque tondeuse sont affichées après l’exécution de la séquence de commandes.
- Le format de sortie correspond aux coordonnées et orientation finales de chaque tondeuse.


### US 7 - Chargement des données depuis un fichier
- `En tant` qu'utilisateur de la tondeuse,
- `je veux`  que les données de configuration (pelouse, positions, commandes) soient lues depuis un fichier,
- `afin` que le programme soit facilement configurable et que les utilisateurs puissent définir les paramètres de manière simple.

#### Critères d'acceptation :
- Les données du fichier sont lues au démarrage du programme.
- Le fichier doit suivre une structure précise : première ligne pour les coordonnées de la pelouse, et deux lignes pour chaque tondeuse (position initiale, puis commande).
- Les erreurs de format dans le fichier doivent être gérées proprement et notifiées.

## Lancer l'application
1. **Builder l'application** : exécutez la commande suivante pour compiler et packager l'application :
   ```bash
   ./mvnw clean package
2. **Préparer le répertoire de travail** :
Copiez le fichier JAR généré (Tondeuse-0.0.1-SNAPSHOT.jar) dans un dossier dédié.
Dans ce dossier, créez un sous-répertoire nommé data.
Placez dans le répertoire data un fichier nommé input.txt contenant la configuration de la tondeuse.

3. **Lancer l'application** :
Exécutez la commande suivante pour lancer le fichier JAR :
   ```bash
   java -jar Tondeuse-0.0.1-SNAPSHOT.jar

4. **Le résultat**: un fichier output.txt sera généré dans le repertoire data.