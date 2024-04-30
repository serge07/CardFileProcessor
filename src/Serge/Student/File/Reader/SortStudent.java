package Serge.Student.File.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class SortStudent {

    public static <e> void main(String[] args) {
        ArrayList<Student> studentRecords = new ArrayList<>();
        String currentLine = "";
        String source = "/Users/serge/Library/CloudStorage/ProtonDrive-amosbiko@protonmail.com/WORK DOCS/Card File Reader/input.txt";
        String destination = "/Users/serge/Library/CloudStorage/ProtonDrive-amosbiko@protonmail.com/WORK DOCS/Card File Reader/output.txt";

        String header="";
        String footer="";
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            //skip header
            header=reader.readLine();

            while ((currentLine = reader.readLine()) != null) {
                //Trimming any leading or trailing whitespace from the read line
                currentLine = currentLine.trim();

                //Checking if the line is empty or starts with "footer" to skip such lines
                if (currentLine.isEmpty()){
                    continue;
                }if(currentLine.startsWith("FOOTER")) {
                    footer = currentLine;
                    break;
                }
                //Reading the body of the line
                String[] studentDetail = currentLine.split(",");
                String name = studentDetail[0];
                int marks = Integer.parseInt(studentDetail[1]);
                studentRecords.add(new Student(name, marks));

            }

            Collections.sort(studentRecords, new MarksCompare());
            writer.write(header);
            writer.newLine();
            for (Student student : studentRecords) {
                writer.write(student.name);
                writer.write("," + student.marks);
                writer.newLine();
            }
            writer.write(footer);
        }catch(IOException e){
                e.printStackTrace();
            }
        }

    }

