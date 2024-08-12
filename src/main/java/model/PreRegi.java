package model;

public class PreRegi {
    private Integer id;
    private String fullName;
    private String gender;
    private String email;
    private String whichTrainingProgram;
    private String whichDateAndBatch;
    private String phoneNo;
    private String currentlyUndergoingTraining;
    private String age;
    private String other;
    private String pleaseProveThatYouAreHumanBySolvingTheEquation;

    public PreRegi(Integer id, String fullName, String gender, String email, String whichTrainingProgram, String whichDateAndBatch, String age, String phoneNo, String currentlyUndergoingTraining, String other, String pleaseProveThatYouAreHumanBySolvingTheEquation) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.whichTrainingProgram = whichTrainingProgram;
        this.whichDateAndBatch = whichDateAndBatch;
        this.age = age;
        this.phoneNo = phoneNo;
        this.currentlyUndergoingTraining = currentlyUndergoingTraining;
        this.other = other;
        this.pleaseProveThatYouAreHumanBySolvingTheEquation = pleaseProveThatYouAreHumanBySolvingTheEquation;
    }

    public PreRegi(String fullName, String age, String gender, String phoneNo, String email, String currentlyUndergoingTraining, String whichTrainingProgram, String other, String whichDateAndBatch, String pleaseProveThatYouAreHumanBySolvingTheEquation) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
        this.currentlyUndergoingTraining = currentlyUndergoingTraining;
        this.whichTrainingProgram = whichTrainingProgram;
        this.other = other;
        this.whichDateAndBatch = whichDateAndBatch;
        this.pleaseProveThatYouAreHumanBySolvingTheEquation = pleaseProveThatYouAreHumanBySolvingTheEquation;
    }

    public PreRegi() {
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhichTrainingProgram() {
        return whichTrainingProgram;
    }

    public void setWhichTrainingProgram(String whichTrainingProgram) {
        this.whichTrainingProgram = whichTrainingProgram;
    }

    public String getWhichDateAndBatch() {
        return whichDateAndBatch;
    }

    public void setWhichDateAndBatch(String whichDateAndBatch) {
        this.whichDateAndBatch = whichDateAndBatch;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCurrentlyUndergoingTraining() {
        return currentlyUndergoingTraining;
    }

    public void setCurrentlyUndergoingTraining(String currentlyUndergoingTraining) {
        this.currentlyUndergoingTraining = currentlyUndergoingTraining;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPleaseProveThatYouAreHumanBySolvingTheEquation() {
        return pleaseProveThatYouAreHumanBySolvingTheEquation;
    }

    public void setPleaseProveThatYouAreHumanBySolvingTheEquation(String pleaseProveThatYouAreHumanBySolvingTheEquation) {
        this.pleaseProveThatYouAreHumanBySolvingTheEquation = pleaseProveThatYouAreHumanBySolvingTheEquation;
    }
}