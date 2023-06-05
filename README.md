# OV1-Back-End-Docker

Voorafgaand: Download eerst Docker en MySQL workbench.

Stap 1:
Open een CMD en clone deze repository met : git clone https://github.com/ADSD-LT04-OV1/OV1-Back-End-Docker.git

Stap 2:
Voor de command in de CMD om een docker image te maken. (zie docker-settings.txt)

Stap 3: 
Run de Docker container en open MySQL workbench. Import de ov-app.sql in MySQL Workbench

Stap 4:
Open InteliJ en ga naar 'Edit configurations'. Klik vervolgens op 'Modify options' en klik 'Environment variables'.
Copy/Paste vervolgens de project variable in de 'Enironment variable'

stap 4: 
Maak de koppeling met de database door op de rechterkant van het scherm op 'Database' te klikken. Druk op '+' en kies 'MySQL'.

stap 5: 
In het vakje 'General' voer je bij 'User' root in en bij 'Password' voer je het wachtwoord in (staat in Docker). Klik daarna op 'Test Connection' en-
check of de verbinding werkt. Zo ja, klik op 'OK' en je kan vervolgens de back-end runnen. 
