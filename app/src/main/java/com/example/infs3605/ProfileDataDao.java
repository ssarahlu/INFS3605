package com.example.infs3605;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.infs3605.Entities.ProfileData;

import java.util.List;

@Dao
public interface ProfileDataDao {

    @Query("SELECT * FROM ProfileData")
    List<ProfileData> getProfileData();

    //get all module data from user
    //this can be used to look at how many / which modules are done 
    @Query("SELECT * FROM ProfileData WHERE email == :email")
    List<ProfileData> getUserModuleData(String email);

    @Query("SELECT * FROM ProfileData WHERE email == :email AND topicId == :topicId")
    List<ProfileData> getTopicUserData(String email, int topicId);

    @Query("SELECT COUNT(*) FROM ProfileData WHERE email == :email AND topicId == :topicId AND videoViewed == :videoViewed AND storyViewed == :storyViewed AND learningsViewed == :learningsViewed AND quizViewed == :quizViewed")
    int countTopicProgress(String email, int topicId, boolean videoViewed, boolean storyViewed, boolean learningsViewed, boolean quizViewed);

    //get one module data for user
    @Query("SELECT * FROM ProfileData WHERE email == :email AND modId == :modId")
    ProfileData getUserProfileData(String email, int modId);

    //use this when user first opens the module (the booleans will be stored as null and quizresult is 0)
    @Query("INSERT OR IGNORE INTO ProfileData VALUES (:modId, :email, :videoViewed, :storyViewed, :learningsViewed, :quizViewed, :quizStars, :topicId)")
    void insertSingleResult(int modId, String email, boolean videoViewed, boolean storyViewed, boolean learningsViewed, boolean quizViewed, int quizStars, int topicId);

    //get stars for that module
    @Query("SELECT quizStars FROM ProfileData WHERE email == :email AND modId == :modId")
    int getQuizStars(String email, int modId);

    //check if they've viewed the video
    @Query("SELECT videoViewed FROM ProfileData WHERE email == :email AND modId == :modId")
    boolean getVideoViewed(String email, int modId);

    //check if they've viewed the story
    @Query("SELECT storyViewed FROM ProfileData WHERE email == :email AND modId == :modId")
    boolean getStoryViewed(String email, int modId);

    //check if they've viewed the learnings
    @Query("SELECT learningsViewed FROM ProfileData WHERE email == :email AND modId == :modId")
    boolean getLearningsViewed(String email, int modId);

    //check if they've viewed the quiz
    @Query("SELECT quizViewed FROM ProfileData WHERE email == :email AND modId == :modId")
    boolean getQuizViewed(String email, int modId);

    //check if they've completed the module
    @Query("SELECT videoViewed, storyViewed, learningsViewed, quizViewed FROM ProfileData WHERE email == :email AND modId == :modId")
    boolean getAllViewed(String email, int modId);

    @Insert
    void insertAll(ProfileData... profileData);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ProfileData profileData);

    @Query("DELETE FROM ProfileData")
    void delAll();

    //will update if the primary keys already exist in the db
    @Update
    public void updateProfileData(ProfileData profileData);

    @Delete
    public void delProfileData(ProfileData profileData);

    @Query("UPDATE ProfileData SET videoViewed = :videoViewed WHERE email == :email AND modId == :modId")
    void updateVideoViewed(boolean videoViewed, String email, int modId);

    @Query("UPDATE ProfileData SET storyViewed = :storyViewed WHERE email == :email AND modId == :modId")
    void updateStoryViewed(boolean storyViewed, String email, int modId);

    @Query("UPDATE ProfileData SET learningsViewed = :learningsViewed WHERE email == :email AND modId == :modId")
    void updateLearningsViewed(boolean learningsViewed, String email, int modId);

    @Query("UPDATE ProfileData SET quizViewed = :quizViewed WHERE email == :email AND modId == :modId")
    void updateQuizViewed(boolean quizViewed, String email, int modId);

    @Query("UPDATE ProfileData SET quizStars = :quizStars WHERE email == :email AND modId == :modId")
    void updateQuizStars(int quizStars, String email, int modId);

}
