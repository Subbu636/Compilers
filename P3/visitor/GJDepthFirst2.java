//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJDepthFirst2<R,A> implements GJVisitor<R,A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
  int Maxi = 1000;
  public HashMap <String,Integer> classNames = new HashMap<>();
  public ArrayList<String>[] variables = new ArrayList[Maxi];
  public ArrayList<String>[] methods = new ArrayList[Maxi];
  public HashMap <String,String> vars = new HashMap<>();
  public HashMap <String,String> temps = new HashMap<>();
  public HashMap <String,String> classes = new HashMap<>();
  public HashMap <String,String> mtds = new HashMap<>();
  String thisClass = "",expList = "",thisMethod = "";
  int label = 0,countParam = 0;
  String newLabel()
  {
    String str = " L"+Integer.toString(label)+" ";
    label++;
    return str;
  }
  int temp = 20;
  String newTemp()
  {
    String str = " TEMP "+Integer.toString(temp)+" ";
    temp++;
    return str;
  }
  int tempx = 1;
  String newTempx()
  {
    String str = " TEMP "+Integer.toString(tempx)+" ";
    tempx++;
    return str;
  }
  
   public R visit(NodeList n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n, A argu) {
      if ( n.present() )
         return n.node.accept(this,argu);
      else
         return null;
   }

   public R visit(NodeSequence n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n, A argu) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> MainClass()
    * f1 -> ( TypeDeclaration() )*
    * f2 -> <EOF>
    */
   public R visit(Goal n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      /*System.out.println(classNames);
      System.out.println();
      System.out.println(methods[0]);
      System.out.println();
      System.out.println(methods[1]);
      System.out.println();
      System.out.println(variables);*/
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> "public"
    * f4 -> "static"
    * f5 -> "void"
    * f6 -> "main"
    * f7 -> "("
    * f8 -> "String"
    * f9 -> "["
    * f10 -> "]"
    * f11 -> Identifier()
    * f12 -> ")"
    * f13 -> "{"
    * f14 -> PrintStatement()
    * f15 -> "}"
    * f16 -> "}"
    */
   public R visit(MainClass n, A argu) {
      R _ret=null;
      System.out.println("MAIN");
      n.f0.accept(this, argu);
      n.f1.accept(this, (A)"just");
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      n.f10.accept(this, argu);
      n.f11.accept(this, (A)"just");
      n.f12.accept(this, argu);
      n.f13.accept(this, argu);
      n.f14.accept(this, argu);
      n.f15.accept(this, argu);
      n.f16.accept(this, argu);
      System.out.println("END");
      return _ret;
   }

   /**
    * f0 -> ClassDeclaration()
    *       | ClassExtendsDeclaration()
    */
   public R visit(TypeDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> ( VarDeclaration() )*
    * f4 -> ( MethodDeclaration() )*
    * f5 -> "}"
    */
   public R visit(ClassDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, (A)"just");
      thisClass = str;
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, (A)str);
      n.f5.accept(this, argu);
      thisClass = "";
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "extends"
    * f3 -> Identifier()
    * f4 -> "{"
    * f5 -> ( VarDeclaration() )*
    * f6 -> ( MethodDeclaration() )*
    * f7 -> "}"
    */
   public R visit(ClassExtendsDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, (A)"just");
      thisClass = str;
      n.f2.accept(this, argu);
      String str1 = (String)n.f3.accept(this, (A)"just");
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, (A)str);
      n.f7.accept(this, argu);
      thisClass = "";
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public R visit(VarDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, (A)"just");
      String str1 = newTemp();
      if(thisMethod.equals(""))
      {
        temps.put(thisClass + "~" + str, str1);
      }
      else
      {
        temps.put(thisClass + "~" + thisMethod + "^" + str, str1);
      }
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "public"
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( FormalParameterList() )?
    * f5 -> ")"
    * f6 -> "{"
    * f7 -> ( VarDeclaration() )*
    * f8 -> ( Statement() )*
    * f9 -> "return"
    * f10 -> Expression()
    * f11 -> ";"
    * f12 -> "}"
    */
   public R visit(MethodDeclaration n, A argu) {
      R _ret=null;
      tempx = 1;
      String str = (String)argu;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String str1 = (String)n.f2.accept(this, (A)"just");
      thisMethod = str1;
      n.f3.accept(this, argu);
      countParam = 0;
      n.f4.accept(this, argu);
      tempx = 1;
      System.out.println("\n"+thisClass+"_"+thisMethod+" ["+ Integer.toString(countParam+1) +"]");
      countParam = 0;
      System.out.println("BEGIN");
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      String str2 = (String)n.f10.accept(this, argu);
      System.out.println("RETURN"+str2+"END");
      n.f11.accept(this, argu);
      n.f12.accept(this, argu);
      thisMethod = "";
      return _ret;
   }

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public R visit(FormalParameterList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public R visit(FormalParameter n, A argu) {
      R _ret=null;
      countParam++;
      String str1 = newTempx();
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, (A)"just");
      if(thisMethod.equals(""))
      {
        temps.put(thisClass + "~" + str, str1);
      }
      else
      {
        temps.put(thisClass + "~" + thisMethod + "^" + str, str1);
      }
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public R visit(FormalParameterRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> ArrayType()
    *       | BooleanType()
    *       | IntegerType()
    *       | Identifier()
    */
   public R visit(Type n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public R visit(ArrayType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "boolean"
    */
   public R visit(BooleanType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "int"
    */
   public R visit(IntegerType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> Block()
    *       | AssignmentStatement()
    *       | ArrayAssignmentStatement()
    *       | IfStatement()
    *       | WhileStatement()
    *       | PrintStatement()
    */
   public R visit(Statement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public R visit(Block n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public R visit(AssignmentStatement n, A argu) {
      R _ret=null;
      argu = (A)"";
      String str2 = "";
      String str = (String)n.f0.accept(this, (A)"just");
      n.f1.accept(this, argu);
      String str1 = (String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      if(temps.containsKey(thisClass+"~"+thisMethod+"^"+str))
     {
       str2 = temps.get(thisClass+"~"+thisMethod+"^"+str);
       System.out.println("MOVE"+str2+str1);
       return (R)str2;
     }
     int x = classNames.get(thisClass);
     int y = -1;
     for(int i = variables[x].size() - 1;i >= 0;--i)
     {
       if(variables[x].get(i).equals(str))
       {
         y = i;
         break;
       }
     }
     System.out.println("HSTORE PLUS TEMP 0 "+Integer.toString(4*(y+1))+" 0"+str1);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "["
    * f2 -> Expression()
    * f3 -> "]"
    * f4 -> "="
    * f5 -> Expression()
    * f6 -> ";"
    */
   public R visit(ArrayAssignmentStatement n, A argu) {
      R _ret=null;
      String str = (String)n.f0.accept(this, (A)"prime");
      n.f1.accept(this, argu);
      String str1 = (String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      String str2 = (String)n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      System.out.println("HSTORE PLUS"+str+"TIMES 4 PLUS 1"+str1+"0"+str2);
      return _ret;
   }

   /**
    * f0 -> IfthenElseStatement()
    *       | IfthenStatement()
    */
   public R visit(IfStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(IfthenStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String str = (String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      String str1 = newLabel();
      System.out.println("CJUMP"+str+str1); // check for correctness
      n.f4.accept(this, argu);
      System.out.println(str1+"NOOP");
      return _ret;
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> "else"
    * f6 -> Statement()
    */
   public R visit(IfthenElseStatement n, A argu) {
      R _ret=null;
      String str1 = newLabel(),str2 = newLabel();
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String str = (String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      System.out.println("CJUMP"+str+str1);
      n.f4.accept(this, argu);
      System.out.println("JUMP"+str2);
      System.out.println(str1+"NOOP");
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      System.out.println(str2+"NOOP");
      return _ret;
   }

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(WhileStatement n, A argu) {
      R _ret=null;
      String str1 = newLabel(),str2 = newLabel();
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      System.out.println(str1+"NOOP");
      String str = (String)n.f2.accept(this, argu);
      System.out.println("CJUMP"+str+str2);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      System.out.println("JUMP" + str1);
      System.out.println(str2+"NOOP");
      return _ret;
   }

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> ";"
    */
   public R visit(PrintStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String str = (String)n.f2.accept(this, argu);
      System.out.println("PRINT"+str);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> OrExpression()
    *       | AndExpression()
    *       | CompareExpression()
    *       | neqExpression()
    *       | PlusExpression()
    *       | MinusExpression()
    *       | TimesExpression()
    *       | DivExpression()
    *       | ArrayLookup()
    *       | ArrayLength() 
    *       | MessageSend()
    *       | PrimaryExpression()
    */
   public R visit(Expression n, A argu) {
      //R _ret=null;
      String str = newTemp();
      String str1 = (String)n.f0.accept(this,argu);
      if(str1.indexOf("$") != -1)
      {
        return (R)str1;
      }
      System.out.println("MOVE"+str+str1);
      return (R)str;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "&&"
    * f2 -> PrimaryExpression()
    */
   public R visit(AndExpression n, A argu) {
      //R _ret=null;
     argu = (A)"";
      String str = (String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String str1 = (String)n.f2.accept(this, argu);
      String str2 = newTemp();
      System.out.println("MOVE"+str2+"TIMES"+str1+str);
      return (R)str2;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "||"
    * f2 -> PrimaryExpression()
    */
   public R visit(OrExpression n, A argu) {
   //R _ret=null;
     argu = (A)"";
        String str = (String)n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        String str1 = (String)n.f2.accept(this, argu);
        String str2 = newTemp();
        String str3 = newTemp();
        System.out.println("MOVE"+str2+"PLUS"+str1+str);
        System.out.println("MOVE"+str3+"NE"+str2+"0");
        return (R)str3;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "<="
    * f2 -> PrimaryExpression()
    */
   public R visit(CompareExpression n, A argu) {
   //R _ret=null;
     argu = (A)"";
        String str = (String)n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        String str1 = (String)n.f2.accept(this, argu);
        String str2 = newTemp();
        System.out.println("MOVE"+str2+"LE"+str+str1); // doubt
        return (R)str2;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "!="
    * f2 -> PrimaryExpression()
    */
   public R visit(neqExpression n, A argu) {
   //R _ret=null;
     argu = (A)"";
        String str = (String)n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        String str1 = (String)n.f2.accept(this, argu);
        String str2 = newTemp();
        System.out.println("MOVE"+str2+"NE"+str+str1); // doubt
        return (R)str2;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "+"
    * f2 -> PrimaryExpression()
    */
   public R visit(PlusExpression n, A argu) {
   //R _ret=null;
     argu = (A)"";
        String str = (String)n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        String str1 = (String)n.f2.accept(this, argu);
        String str2 = newTemp();
        System.out.println("MOVE "+str2+"PLUS"+str+str1);
        return (R)str2;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "-"
    * f2 -> PrimaryExpression()
    */
   public R visit(MinusExpression n, A argu) {
   //R _ret=null;
     argu = (A)"";
        String str = (String)n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        String str1 = (String)n.f2.accept(this, argu);
        String str2 = newTemp();
        System.out.println("MOVE"+str2+"MINUS"+str+str1);
        return (R)str2;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "*"
    * f2 -> PrimaryExpression()
    */
   public R visit(TimesExpression n, A argu) {
   //R _ret=null;
     argu = (A)"";
        String str = (String)n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        String str1 = (String)n.f2.accept(this, argu);
        String str2 = newTemp();
        System.out.println("MOVE"+str2+"TIMES"+str+str1);
        return (R)str2;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "/"
    * f2 -> PrimaryExpression()
    */
   public R visit(DivExpression n, A argu) {
   //R _ret=null;
     argu = (A)"";
        String str = (String)n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        String str1 = (String)n.f2.accept(this, argu);
        String str2 = newTemp();
        System.out.println("MOVE"+str2+"DIV"+str+str1);
        return (R)str2;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "["
    * f2 -> PrimaryExpression()
    * f3 -> "]"
    */
   public R visit(ArrayLookup n, A argu) {
      R _ret=null;
      argu = (A)"";
      String str = (String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String str1 = (String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      String str2 = newTemp();
      System.out.println("HLOAD"+str2+"PLUS"+str+"TIMES 4 PLUS 1"+str1+"0");
      return (R)str2;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> "length"
    */
   public R visit(ArrayLength n, A argu) {
      R _ret=null;
      argu = (A)"";
      String str = (String)n.f0.accept(this, argu);
      String str1 = newTemp();
      System.out.println("HLOAD"+str1+str+"0");
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return (R)str1;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( ExpressionList() )?
    * f5 -> ")"
    */
   public R visit(MessageSend n, A argu) {
      R _ret=null;
      String strw = (String) argu;
      String str = (String)n.f0.accept(this, (A)"class");
      n.f1.accept(this, argu);
      String str1 = (String)n.f2.accept(this, (A)"just");
      String stry = mtds.get(str.substring(0,str.indexOf("$"))+"~"+str1);
      n.f3.accept(this, argu);
      expList = "";
      n.f4.accept(this, (A)"");
      //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++"); // ++++++++++++++++++++++++++++++++++++++++++++++
      //System.out.println(str);
      int x = classNames.get(str.substring(0,str.indexOf("$")));
      str = str.substring(str.indexOf("$")+1);
      int offset = 0;
      for(int i = methods[x].size() - 1;i >= 0;i--)
      {
        String str3 = methods[x].get(i).substring(methods[x].get(i).indexOf("_")+1);
        if(str3.equals(str1))
        {
          offset = i;
        }
      }
      n.f5.accept(this, argu);
      String str4 = newTemp();
      String str5 = newTemp();
      String str6 = newTemp();
      String str8 = newTemp();
      String str7 = "MOVE" + str8;
      str7 = str7 + "\nCALL\nBEGIN\n";
      str7 = str7 + "MOVE" + str4  + str + "\n";
      str7 = str7 + "HLOAD" + str5 + str4 + "0" + "\n";
      str7 = str7 + "HLOAD" + str6 + str5 + Integer.toString(4*offset) + "\n";
      str7 = str7 + "RETURN" + str6 + "END\n";
      //System.out.println(":::"+expList);
      str7 = str7 + "(" + str4 + expList + ")\n";
      expList = "";
      System.out.println(str7);
      if(strw.equals("class"))
      {
        //System.out.println("-------------------------------------"); // ++++++++++++++++++++++++++++++++++++++++++++++
          //System.out.println(stry);
        str8 = stry+"$"+str8;
        //System.out.println(str);
      }
      return (R)str8;
   }

   /**
    * f0 -> Expression()
    * f1 -> ( ExpressionRest() )*
    */
   public R visit(ExpressionList n, A argu) {
      R _ret=null;
      String str1 = expList;
      String str = (String)n.f0.accept(this, argu);
      expList = str1;
      n.f1.accept(this, argu);
      expList =str+ expList ;
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Expression()
    */
   public R visit(ExpressionRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String str1 = expList;
      String str = (String)n.f1.accept(this, argu);
      expList = str1;
      expList = str + expList ;
      return _ret;
   }

   /**
    * f0 -> IntegerLiteral()
    *       | TrueLiteral()
    *       | FalseLiteral()
    *       | Identifier()
    *       | ThisExpression()
    *       | ArrayAllocationExpression()
    *       | AllocationExpression()
    *       | NotExpression()
    *       | BracketExpression()
    */
   public R visit(PrimaryExpression n, A argu) {
      //R _ret=null;
     String str1 = (String)argu;
     if(!str1.equals("class"))
     {
       str1 = "prime";
     }
      R str = n.f0.accept(this, (A)str1);
      return str;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu) {
      //R _ret=null;
      String _ret = n.f0.tokenImage;
      _ret = " " + _ret + " ";
      return (R)_ret;
   }

   /**
    * f0 -> "true"
    */
   public R visit(TrueLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)" 1 ";
   }

   /**
    * f0 -> "false"
    */
   public R visit(FalseLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)" 0 ";
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n, A argu) {
      //R _ret=null;
     String str = (String) argu;
     String _ret = n.f0.tokenImage;
     String str2 = "";
     if(str.equals("just"))
     {
       return (R)_ret;
     }
     if(temps.containsKey(thisClass+"~"+thisMethod+"^"+_ret))
     {
       str2 = temps.get(thisClass+"~"+thisMethod+"^"+_ret);
     }
     else if(!thisClass.equals(""))
     {
       int x = classNames.get(thisClass);
       int y = -1;
       for(int i = variables[x].size() - 1;i >= 0;--i)
       {
         if(variables[x].get(i).equals(_ret))
         {
           y = i;
           break;
         }
       }
       if(y != -1)
       {
         str2 = newTemp();
         String str3 = newTemp();
         System.out.println("MOVE"+str3+"TEMP 0");
         System.out.println("HLOAD"+str2+str3+Integer.toString(4*(y + 1)));
       }
     }
     if(str.equals("class"))
     {
       String str1 = "";
       if(vars.containsKey(thisClass+"~"+thisMethod+"^"+_ret))
       {
         str1 = vars.get(thisClass+"~"+thisMethod+"^"+_ret);
       }
       else
       {
         String var = thisClass;
         while(true)
         {
           if(vars.containsKey(var+"~"+_ret))
           {
             str1 = vars.get(var+"~"+_ret);
             break;
           }
           var = classes.get(var);
           if(var.equals("end"))
           {
             break;
           }
         }
       }
       _ret = str1 + "$" + str2;
     }
     if(str.equals("prime"))
     {
       _ret = str2;
     }
      return (R)_ret;
   }

   /**
    * f0 -> "this"
    */
   public R visit(ThisExpression n, A argu) {
      //R _ret=null;
      n.f0.accept(this, argu);
      String str = (String)argu;
      if(str.equals("class"))
      {
        return (R)(thisClass+"$ TEMP 0 ");
      }
      return (R)" TEMP 0 ";
   }

   /**
    * f0 -> "new"
    * f1 -> "int"
    * f2 -> "["
    * f3 -> Expression()
    * f4 -> "]"
    */
   public R visit(ArrayAllocationExpression n, A argu) {
      //R _ret=null;
      argu = (A)"";
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      String str = (String)n.f3.accept(this, argu);
      String str1 = newTemp();
      String str2 = newTemp();
      String str3 = newLabel(),str5 = newLabel();
      String str4 = newTemp();
      n.f4.accept(this, argu);
      System.out.println("MOVE"+str1+"HALLOCATE TIMES 4 "+"PLUS 1"+str); // doubt
      System.out.println("HSTORE"+str1+"0"+str);
      System.out.println("MOVE"+str2+"1");
      System.out.println(str3+"NOOP");
      System.out.println("CJUMP LE"+str2+str+str5);
      System.out.println("HSTORE PLUS"+str1+"TIMES 4"+str2+"0"+"0");
      System.out.println("MOVE"+str4+"PLUS 1"+str2);
      System.out.println("MOVE"+str2+str4);
      System.out.println("JUMP"+str3);
      System.out.println(str5+"NOOP");
      return (R)str1;
   }

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public R visit(AllocationExpression n, A argu) {
      //R _ret=null;
     int q = 0;
     String strx = (String)argu;
     if(strx.equals("class"))
     {
       q = 1;
     }
     argu = (A)"";
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, (A)"just");
      int x = classNames.get(str);
      String str2 = newTemp();
      String str3 = newTemp();
      String str5 = newTemp();
      String str1 = "";
      if(q == 0)
      {
        str1 = "MOVE" + str5;
      }
      str1 = str1 + "\nBEGIN\n";
      str1 = str1 + "MOVE"+str2+"HALLOCATE "+Integer.toString(4*(variables[x].size()+1))+"\n";
      str1 = str1 + "MOVE"+str3+"HALLOCATE "+Integer.toString(4*(methods[x].size()))+"\n";
      for(int i = 0;i < methods[x].size();i++)
      {
        str1 = str1 + "HSTORE" + str3 + Integer.toString(4*i) + " " +methods[x].get(i)+"\n";
      }
      str1 = str1 + "HSTORE" + str2 + Integer.toString(0) + " " + str3 + "\n";
      for(int i = 1;i <= variables[x].size();i++)
      {
        str1 = str1 + "HSTORE" + str2 + Integer.toString(4*i) + " " + Integer.toString(0) + "\n";
      }
      str1 = str1 + "RETURN" + str2 + "END";
      strx = str1;
      str1 = str + "$" + str1;
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      if(q == 1)
      {
        return (R)str1;
      }
      else
      {
        System.out.println(strx);
        return (R)str5;
      }
   }

   /**
    * f0 -> "!"
    * f1 -> Expression()
    */
   public R visit(NotExpression n, A argu) {
      R _ret=null;
      argu = (A)"";
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, argu);
      String str1 = newTemp();
      System.out.println("MOVE" + str1 + "NE" + str + "1");
      return (R)str1;
   }

   /**
    * f0 -> "("
    * f1 -> Expression()
    * f2 -> ")"
    */
   public R visit(BracketExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      //String str1 = newTemp();
      String str = (String)n.f1.accept(this, argu);
      //System.out.println("MOVE" + str1 +  str);
      n.f2.accept(this, argu);
      return (R)str;
   }

   /**
    * f0 -> Identifier()
    * f1 -> ( IdentifierRest() )*
    */
   public R visit(IdentifierList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Identifier()
    */
   public R visit(IdentifierRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

}
