SIPI18
Datorkommunikation och nätverk
Nicklas Holmberg, Dennis Larsson, Anders Nilsson

Sammanfattnig:

Vi har gjort en enkel nätverkschatt via sockets och går på localhost. För att köra detta program behövs lite jar filer, vileket finns i lib katalogen.
 
Som bonus skickar vi även med klassen chatTestIt som startar ett  chatfönster och skickar meddelanden direkt till console. Denna användes för att testa fram ChatUI klassen. Denna klass har en egen main.

Mycket nöje! Det bästa med denna chat är att man får precis de svar man vill ha från den andra parten.

Chat:


Chatten är uppbygd med en server och klient som bygger varsitt fönster utifrån en förbestämd mall (ChatUI). Då både serven och klienten är beroende av outputstream tar ChatUI det som parameter. Det och en string som är namnet på fönstret (title). Servern och Klienten är två trådar som har en direkt koppling mot varandra. 

I ChatUI finns även alla förinställda metoder för att skicka, ta emot och visa inkommande och utgående text. Utgående text är uppbyggt på en writer medans det man själv skriver visas som en vanlig string. Båda sker i metoden “printLineMethod” och sker med en vanlig entertryckning.
Här finns även about knappen som hämtar JSON och printar det (Se avsnitt JSON).

ChatClienten använder sig av InetAddress.getLocalHost och socket är ställt till 10011.
ChatServern accepterar clientens anrop och trådarna är sammankopplade till en chat.

JSON:

Authors.json innehåller ett litet JSON-objekt, som anropas genom en metod (aboutButtonPressed) i About.java. Här används ett finurligt bibliotek som kallas Jackson, som konverterar JSON-objekt till java-objekt (på internet ofta kallat “POJO” - ‘Plain Old Java Object’) och sedan prydligt skrivs ut.



