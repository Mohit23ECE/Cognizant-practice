class Exercise03SingletonPatternExample {
 static final class MessageJournal {
 private static MessageJournal sharedJournal;
 private int noteCount;
 private MessageJournal() {
 noteCount = 0;
 }
 static synchronized MessageJournal instance() {
 if (sharedJournal == null) {
 sharedJournal = new MessageJournal();
 }
 return sharedJournal;
 }
 void addNote(String entryText) {
 noteCount++;
 System.out.println("Journal " + noteCount + ": " + entryText);
 }
 }
 public static void main(String[] args) {
 MessageJournal firstHandle = MessageJournal.instance();
 MessageJournal secondHandle = MessageJournal.instance();
 firstHandle.addNote("Inventory sync completed");
 secondHandle.addNote("Payment report exported");
 System.out.println("Both handles point to one object: " + (firstHandle == secondHandle));
 }
}
