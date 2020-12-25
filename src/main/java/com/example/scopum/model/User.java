package com.example.scopum.model;


import com.example.scopum.Bot.Message;
import com.example.scopum.Bot.botapi.BotContext;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    private Long chatId;
    @Column(name = "state")
    private Integer stateId;
    @Column(name = "age")
    private int age; // Возраст пользователя
    @Column(name = "weight")
    private double weight; // Вес пользователя
    @Column(name = "growth")
    private int growth; // Рост пользователя
    @Column(name = "gender")
    private String gender; // Пол пользователя
    @Column(name = "employment")
    private double employment; // Уровень занятости пользователя(1-5)
    @Column(name = "calories")
    private double calories;
    @Column(name = "proteins")
    private double proteins;
    @Column(name = "fat")
    private double fat;
    @Column(name = "carbohydrates")
    private double carbohydrates;
    @Column(name = "botfunction")
    private String botFunction;
    @Column(name = "allergyproducts")
    private String allergyProducts;
    @Column(name = "iscorrect")
    private boolean isCorrect = true;
    @Column(name = "tracking")
    private boolean tracking;
    @Column(name = "lastcalpfc")
    private String lastCalPFC;

    public String getLastCalPFC() {
        return lastCalPFC;
    }

    public void setLastCalPFC(double[] lastCalPFC) {
        this.lastCalPFC = lastCalPFC[0] + "_" + lastCalPFC[1] + "_" + lastCalPFC[2] + "_" + lastCalPFC[3];
    }

    public boolean isTracking() {
        return tracking;
    }

    public void setTracking(boolean tracking) {
        this.tracking = tracking;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getBotFunction() {
        return botFunction;
    }

    public void setBotFunction(String botFunction) {
        this.botFunction = botFunction;
    }

    public double[] getCalPFC() {
        return new double[] {calories, proteins, fat, carbohydrates};
    }

    public void setCalPFC(double[] calPFC) {
        this.calories = calPFC[0];
        this.proteins = calPFC[1];
        this.fat = calPFC[2];
        this.carbohydrates = calPFC[3];
    }

    public void setTrackingCalPFC(double[] calPFC) {
        this.calories -= calPFC[0];
        this.proteins -= calPFC[1];
        this.fat -= calPFC[2];
        this.carbohydrates -= calPFC[3];
    }

    public void setCalories(String caloriesIn, BotContext context) {
        double calories;
        isCorrect = false;
        if (caloriesIn != null && !caloriesIn.equals("")) {
            try {
                calories = Double.parseDouble(caloriesIn);
                if (calories < 0.0d) {
                    Message message = new Message();
                    message.informAboutIncorrectUserInput(context);
                } else {
                    this.calories = calories;
                    isCorrect = true;
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                Message message = new Message();
                message.informAboutIncorrectUserInput(context);
            }
        } else {
            Message message = new Message();
            message.informAboutIncorrectUserInput(context);
        }
    }

    public void setProteins(String proteinsIn, BotContext context) {
        double proteins;
        isCorrect = false;
        if (proteinsIn != null && !proteinsIn.equals("")) {
            try {
                proteins = Double.parseDouble(proteinsIn);
                if (proteins < 0.0d) {
                    Message message = new Message();
                    message.informAboutIncorrectUserInput(context);
                } else {
                    this.proteins = proteins;
                    isCorrect = true;
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                Message message = new Message();
                message.informAboutIncorrectUserInput(context);
            }
        } else {
            Message message = new Message();
            message.informAboutIncorrectUserInput(context);
        }
    }

    public void setFat(String fatIn, BotContext context) {
        double fat;
        isCorrect = false;
        if (fatIn != null && !fatIn.equals("")) {
            try {
                fat = Double.parseDouble(fatIn);
                if (fat < 0.0d) {
                    Message message = new Message();
                    message.informAboutIncorrectUserInput(context);
                } else {
                    this.fat = fat;
                    isCorrect = true;
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                Message message = new Message();
                message.informAboutIncorrectUserInput(context);
            }
        } else {
            Message message = new Message();
            message.informAboutIncorrectUserInput(context);
        }
    }

    public void setCarbohydrates(String carbohydratesIn, BotContext context) {
        double carbohydrates;
        isCorrect = false;
        if (carbohydratesIn != null && !carbohydratesIn.equals("")) {
            try {
                carbohydrates = Double.parseDouble(carbohydratesIn);
                if (carbohydrates < 0.0d) {
                    Message message = new Message();
                    message.informAboutIncorrectUserInput(context);
                } else {
                    this.carbohydrates = carbohydrates;
                    isCorrect = true;
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                Message message = new Message();
                message.informAboutIncorrectUserInput(context);
            }
        } else {
            Message message = new Message();
            message.informAboutIncorrectUserInput(context);
        }
    }

    public Long getChatId() {
        return chatId;
    }


    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }


    public User() {

    }


    public User(Long chatId, Integer state) {
        this.chatId = chatId;
        this.stateId = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(String ageIn, BotContext context) {
        int age;
        isCorrect = false;
        if (ageIn != null && !ageIn.equals("")) {
            try {
                age = Integer.parseInt(ageIn);
                if (age > 122 || age <= 0) {
                    Message message = new Message();
                    message.informAboutIncorrectUserInput(context);
                } else {
                    this.age = age;
                    isCorrect = true;
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                Message message = new Message();
                message.informAboutIncorrectUserInput(context);
            }
        } else {
            Message message = new Message();
            message.informAboutIncorrectUserInput(context);
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(String weightIn, BotContext context) {
        double weight;
        isCorrect = false;
        if (weightIn != null && !weightIn.equals("")) {
            try {
                weight = Double.parseDouble(weightIn);
                if (weight <= 0.0d) {
                    Message message = new Message();
                    message.informAboutIncorrectUserInput(context);
                } else {
                    this.weight = weight;
                    isCorrect = true;
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                Message message = new Message();
                message.informAboutIncorrectUserInput(context);
            }
        } else {
            Message message = new Message();
            message.informAboutIncorrectUserInput(context);
        }
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(String growthIn, BotContext context) {
        int growth;
        isCorrect = false;
        if (growthIn != null && !growthIn.equals("")) {
            try {
                growth = Integer.parseInt(growthIn);
                if (growth <= 0) {
                    Message message = new Message();
                    message.informAboutIncorrectUserInput(context);
                } else {
                    this.growth = growth;
                    isCorrect = true;
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                Message message = new Message();
                message.informAboutIncorrectUserInput(context);
            }
        } else {
            Message message = new Message();
            message.informAboutIncorrectUserInput(context);
        }
    }

    public Gender getGender() {
        if (gender.equals("Мужчина")) {
            return Gender.male;
        } else if (gender.equals("Женщина")) {
            return Gender.female;
        }
        return Gender.male;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getEmployment() {
        return employment;
    }

    public void setEmployment(double employment) {
        this.employment = employment;
    }

    public void setAllergyProducts(String allergyProducts, BotContext context) {
        if (Pattern.matches("^-?[0-9][0-9,\\.]+$", allergyProducts)) {
            Message message = new Message();
            message.informAboutIncorrectUserInput(context);
            isCorrect = false;
        } else {
            this.allergyProducts = allergyProducts.toLowerCase();
            isCorrect = true;
        }

    }

    public String[] getAllergyProducts() {
        if (this.allergyProducts != null) {
            List<String> allergy = Arrays.asList(this.allergyProducts.split(" "));
            return allergy.toArray(String[]::new);
        }
        return null;
    }

    public void clickButton (String text) {
        switch (text) {
            case "Включить трекинг":
                setTracking(true);
                break;
            case "Выключить трекинг":
                setTracking(false);
                setLastCalPFC(new double[] {0.0, 0.0, 0.0, 0.0});
                break;
            case "Отменить последний подсчет КБЖУ":
                double[] lastCalPFC = new double[4];
                String lastUserCalPFC = getLastCalPFC();

                for (int i = 0; i < 4; i++) {
                    lastCalPFC[i] = Double.parseDouble(lastUserCalPFC.split("_")[i]);
                }
                this.calories = lastCalPFC[0];
                this.proteins = lastCalPFC[1];
                this.fat = lastCalPFC[2];
                this.carbohydrates = lastCalPFC[3];

                break;
        }
    }
}
