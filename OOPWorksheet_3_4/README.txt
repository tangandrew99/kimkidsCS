OOP Worksheet – IntelliJ Project
=================================

HOW TO OPEN:
  File > Open > select the OOPWorksheet3 folder
  The src/test folders should already be marked automatically.

IF TESTS WON'T RUN (JUnit not found):
  The project is configured to use JUnit5 from your local Maven cache.
  If IntelliJ shows a "cannot resolve" error on the imports:
    1. Click the red lightbulb on the import line
    2. Choose "Add JUnit5 to classpath" — IntelliJ will download it automatically
  OR manually:
    File > Project Structure > Libraries > + > From Maven
    Search: org.junit.jupiter:junit-jupiter:5.10.0 > OK

FOLDER STRUCTURE:
  Problem1_Library_and_Book/       src/ test/
  Problem2_Student_and_Gradebook/  src/ test/
  Problem3_Product_and_Store/      src/ test/
  Problem4_Player_and_Game/        src/ test/
  Problem5_Task_and_TodoList/      src/ test/
  Problem6_BankAccount_and_Bank/   src/ test/

  Fill in every __________ in the src/ files.
  Right-click any *Test.java > Run to check. Green = correct!
