package Mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Fields {
    public static final ArrayList<String> allowedFieldValues = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
    private final int size;
    private final ArrayList<String> fields;

    public Fields(int size) {
        this.size = size;
        this.fields = new ArrayList<>();
    }

    public void setFields(Scanner sc){
        System.out.println("Унесите поља у формату: " + "X ".repeat(size));
        fields.clear();
        for(int i = 0; i < size; i++){
            fields.add(sc.next());
        }
        if(!allowedFieldValues.containsAll(fields)){
            System.out.println("Дозвољена поља: " + allowedFieldValues);
            setFields(sc);
        }
    }

    public void setRandomFields(){
        fields.clear();
        for(int i = 0; i < size; i++){
            var randomFieldIndex = (int) (Math.random() * allowedFieldValues.size());
            fields.add(allowedFieldValues.get(randomFieldIndex));
        }
    }

    public void compareFields(Fields input){
        int countCorrectPosition = 0;
        int countIncorrectPosition = 0;

        ArrayList<String> fieldsList = new ArrayList<>(fields);
        ArrayList<Integer> indexesToSkip = new ArrayList<>();

        for(int i = 0; i < input.fields.size(); i++){
            if(input.fields.get(i).equals(fields.get(i))){
                countCorrectPosition++;
                fieldsList.set(i, null);
                indexesToSkip.add(i);
            }
        }

        for (int i = 0; i < input.fields.size(); i++) {
            if (!indexesToSkip.contains(i) && fieldsList.contains(input.fields.get(i))) {
                var index = fieldsList.indexOf(input.fields.get(i));
                fieldsList.set(index, null);
                countIncorrectPosition++;
            }
        }

        System.out.println("☻ ".repeat(countCorrectPosition) + "☺ ".repeat(countIncorrectPosition));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fields fields1 = (Fields) o;
        return Objects.equals(fields, fields1.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields);
    }
}

