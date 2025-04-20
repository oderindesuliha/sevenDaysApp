package DiaryApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    Diary myDiary = new Diary("Omobolanle", "correctPassword");


    @Test
    public void testThatDiaryIsLocked() {
        myDiary.lock();
        assertFalse(myDiary.isLocked());
    }

    @Test
    public void testThatDiaryIsUnlocked() {
        myDiary.unlock("correctPassword");
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void testThatDiaryIsLockedAndThenUnlocked() {
        myDiary.lock();
        myDiary.unlock("correctPassword");
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void testThatDiaryIsUnlockedAfterACorrectPasswordIsEntered() {
        myDiary.lock();
        myDiary.unlock("correctPassword");
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void testThatDiaryRemainsLockedAfterAnIncorrectPasswordIsEntered() {
        myDiary.lock();
        myDiary.unlock("incorrectPassword");
        myDiary.lock();
        assertFalse(myDiary.isLocked());
    }
    
    @Test
    public void testThatDiaryCreatesEntryAfterUsernameAndPasswordAreCorrect(){
        myDiary.lock();
        myDiary.getUserName();
        myDiary.unlock("correctPassword");
        myDiary.createEntry("title","body");
    }
      






}