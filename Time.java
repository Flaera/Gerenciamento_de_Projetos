// import java.util.Calendar;
import java.util.Scanner;


public class Time {
    private int CURRENT_YEAR = 2022;
    static private Scanner opt;
    // private Calendar calendar;
    private int data_day = -1;
    private int data_montly = -1;
    private int data_year = -1;
    private int hour = -1;
    private int minutes = -1;
    private int seconds = -1;

    private int terminate_data_day = -1;
    private int terminate_data_montly = -1;
    private int terminate_data_year = -1;
    private int terminate_hour = -1;
    private int terminate_minutes = -1;
    private int terminate_seconds = -1;

    public Time(int data_d, int data_mon, int data_y, int h, int min, int sec,
     int term_data_d, int term_data_mon, int term_data_y, int term_h, int term_min, int term_sec){
        // calendar.getInstance();
        if (((data_d>0 && data_d<=31) && (data_mon>0 && data_mon<=12)
         && (data_y>0 && data_y<=CURRENT_YEAR)
          && (h>=0 && h<=23) && (min>=0 && min<=59)
           && (sec>=0 && sec<=59))
            &&
             ((term_data_d>0 && term_data_d<=31) && (term_data_mon>0) && (term_data_mon<=12)
           && (term_data_y>=CURRENT_YEAR)
            && (term_h>=0 && term_h<=23) && (term_min>=0 && term_min<=59)
             && (term_sec>=0 && term_sec<=59)))
        {
            this.data_day = data_d;
            this.data_montly = data_mon;
            this.data_year = data_y;
            this.hour = h;
            this.minutes = min;
            this.seconds = sec;

            this.terminate_data_day = term_data_d;
            this.terminate_data_montly = term_data_mon;
            this.terminate_data_year = term_data_y;
            this.terminate_hour = term_h;
            this.terminate_minutes = term_min;
            this.terminate_seconds = term_sec;
        }
        else{
            System.out.println("Erro na atribuição da data. Possivelmente a data esta errada.");
        }
    }
    public int getDayInit(){return this.data_day;}
    public int getMontlyInit(){return this.data_montly;}
    public int getYearInit(){return this.data_year;}
    public int getHourInit(){return this.hour;}
    public int getMinInit(){return this.minutes;}
    public int getSecInit(){return this.seconds;}

    public int getDayTerm(){return this.terminate_data_day;}
    public int getMontlyTerm(){return this.terminate_data_montly;}
    public int getYearTerm(){return this.terminate_data_year;}
    public int getHourTerm(){return this.terminate_hour;}
    public int getMinTerm(){return this.terminate_minutes;}
    public int getSecTerm(){return this.terminate_seconds;}

    public void setDayInit(int n){this.data_day = n;}
    public void setMontlyInit(int n){this.data_montly = n;}
    public void setYearInit(int n){this.data_year = n;}
    public void setHourInit(int n){this.hour = n;}
    public void setMinInit(int n){this.minutes = n;}
    public void setSecInit(int n){this.seconds = n;}

    public void setDayTerm(int n){this.terminate_data_day = n;}
    public void setMontlyTerm(int n){this.terminate_data_montly = n;}
    public void setYearTerm(int n){this.terminate_data_year = n;}
    public void setHourTerm(int n){this.terminate_hour = n;}
    public void setMinTerm(int n){this.terminate_minutes = n;}
    public void setSecTerm(int n){this.terminate_seconds = n;}

    public String getDataCreationString(){
        if (getDayInit()!= -1
        && getMontlyInit() != -1
        && getYearInit() != -1
        && getHourInit() != -1
        && getMinInit() != -1
        && getSecInit() != -1)
        {
            return getDayInit()+"/"+getMontlyInit()+"/"+getYearInit()+" - "+getHourInit()+":"+getMinInit()+":"+getSecInit();
        }
        return "Data não atribuída";
    }
    public String getDataTerminateString(){
        try{
            if (getDayTerm() != -1
                && getMontlyTerm() != -1
                && getYearTerm() != -1
                && getHourTerm() != -1
                && getMinTerm() != -1
                && getSecTerm() != -1)
            {
                return getDayTerm()+"/"+getMontlyTerm()+"/"+getYearTerm()+" - "+getHourTerm()+":"+getMinTerm()+":"+getSecTerm();
            }
        } catch (NullPointerException | NumberFormatException e){
            System.out.println("Erro na atribuição. Datas inconsistentes. Erro: "+e);
        }
        return "Data não atribuída";
    }
    public void setDataCreationString(int day_init, int montly_init, int year_init,
        int hour_init, int min_init, int sec_init){
        try{
            setDayInit(day_init);
            setMontlyInit(montly_init);
            setYearInit(year_init);
            setHourInit(hour_init);
            setMinInit(min_init);
            setSecInit(sec_init);
        } catch (NullPointerException | NumberFormatException e){
            System.out.println("Erro na atribuição. Datas inconsistentes. Erro: "+e);
        }
    }
    public void setDataTerminateString(int day_term, int montly_term, int year_term, int hour_term,
        int min_term, int sec_term){
        try{
            setDayTerm(day_term);
            setMontlyTerm(montly_term);
            setYearTerm(year_term);
            setHourTerm(hour_term);
            setMinTerm(min_term);
            setSecTerm(sec_term);
        } catch (NullPointerException | NumberFormatException e){
            System.out.println("Erro na atribuição. Datas inconsistentes. Erro: "+e);
        }
    }
    static public void main(String args[]){
        opt.close();
    }
}
