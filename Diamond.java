import java.util.Scanner;

public class Diamond {

  private static int inputNum;
  private static int indentNum;
  private static String evenTip = "";
  private static String indent = "";
  private static String oddRow = "*";
  private static String evenRow = "";
  private static String row;
  private static int indentLoop;
  private static int remainder;

  public static void main(String[] args) {

    System.out.println("Enter a number:");

    Scanner input = new Scanner(System.in);

    inputNum = input.nextInt();
    indentNum = inputNum / 2;
    input.close();

    remainder = inputNum % 2;

  //Odd diamond
    if (remainder != 0) {

    //Top-half of diamond
      while(indentNum >= 0){
        indent = getIndentsOdd();

        row = indent.concat(oddRow);
        oddRow = oddRow.concat("**");

        System.out.println(row);

        indentNum = indentNum - 1;
      }

    //Resetting indent
      indent = "";


    //Bottom-half of diamond
      while(indentNum < 0 && indentNum > (-1 - (inputNum / 2))){
        oddRow = getRow();

        indent = indent.concat(" ");

        row = indent.concat(oddRow);
        row = row.concat("*");

        System.out.println(row);

        indentNum = indentNum - 1;
      }

  //Even diamond
    } else {
    //Setting tip of otherwise blunt diamond
    //-----------------------------------------------------------------------------------------
      indentNum--;

      evenTip = getIndentsEven();
      evenTip = evenTip.concat(" *");

      indentNum++;

      System.out.print(evenTip);
    //-----------------------------------------------------------------------------------------

    //Top-half of diamond
      while(indentNum >= 0){
        indent = getIndentsEven();

        row = indent.concat(evenRow);
        evenRow = evenRow.concat("* * ");

        System.out.println(row);

        indentNum = indentNum - 1;
      }

    //Reseting indent
      indent = "";

    //Bottom-half of diamond
      while(indentNum < 0 && indentNum > (-1 - (inputNum / 2))){
        evenRow = getRow();

        if (indentNum != -1) {
          indent = indent.concat("  ");
        } else {
          indent = indent.concat(" ");
        }

        row = indent.concat(evenRow);

        System.out.println(row);

        indentNum = indentNum - 1;
      }
    }
  }

  private static String getIndentsOdd(){
    String space = "";
  //
    for(indentLoop = indentNum; indentLoop > 0; indentLoop--){
      space = space.concat(" ");
    }

    return space;
  }

  private static String getIndentsEven(){
    String space = "";

    for(indentLoop = indentNum; indentLoop > 0; indentLoop--){
      space = space.concat("  ");
    }

    return space;
  }

  private static String getRow(){
    String mark = "";

    if(remainder != 0){
    //Now that indentNum is below 0, we check to see for a distance inbetween it and the original indentNum, this time with 0 at the top, working our way technically down
      for(indentLoop = indentNum; indentLoop > (0 - (inputNum / 2)); indentLoop--){
        mark = mark.concat("**");
      }
    } else {
    //Now that indentNum is below 0, we check to see for a distance inbetween 0 and the original indentNum, this time with 0 at the top, working our way technically down
      if (indentNum == (0 - (inputNum / 2))) {
        mark = mark.concat("*");
      } else {
        for(indentLoop = indentNum; indentLoop > (0 - (inputNum / 2)); indentLoop--){
            mark = mark.concat(" * *");
        }
      }
    }

    return mark;
  }
}
