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
	  String thisClass = "",expList = "",thisMethod = "",clsVar = "",formPara = "";
	  int label = 0,countParam = 0,clsvarNum = 0;
	  String newLabel()
	  {
	    String str = "l"+Integer.toString(label)+":";
	    label++;
	    return str;
	  }
	  int temp = 20;
	  String newTemp()
	  {
	    String str = "%temp"+Integer.toString(temp);
	    temp++;
	    return str;
	  }
	  int tempx = 1;
	  String newTempx()
	  {
	    String str = "%temp"+Integer.toString(tempx);
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
      System.out.println("@formatString = constant [4 x i8] c\"%d\\0A\\00\"\n" + 
      		"declare i32 @printf(i8*, ...)");
      System.out.println();
      System.out.println("define i32 @main() {");
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
      System.out.println("}");
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
      clsVar = "";
      clsvarNum = 0;
      n.f3.accept(this, argu);
      System.out.println("%"+thisClass+" = type { "+clsVar.substring(1)+" }");
      clsVar = "";
      clsvarNum = 0;
      n.f4.accept(this, argu);
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
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      clsVar = "";
      clsvarNum = 0;
      n.f5.accept(this, argu);
      System.out.println("%"+thisClass+" = type { "+clsVar.substring(1)+" }");
      clsVar = "";
      clsvarNum = 0;
      n.f6.accept(this, argu);
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
      String str1 = (String)n.f0.accept(this, (A)"cls");
      String str = (String)n.f1.accept(this, (A)"just");
      if(thisMethod.equals(""))
      {
          if(str1.equals("int") || str1.equals("bool"))
          {
        	  str1 = "i32";
          }
          else if(str1.equals("arr"))
          {
        	  str1 = "i32*";
          }
          else
          {
        	  str1 = str1;
          }
        temps.put(thisClass + "~" + str, Integer.toString(clsvarNum));
        clsvarNum++;
        clsVar = clsVar + ", "+str1;
      }
      else
      {
          if(str1.equals("int") || str1.equals("bool"))
          {
        	  str1 = "alloca i32, align 4";
          }
          else if(str1.equals("arr"))
          {
        	  str1 = "";
          }
          else
          {
        	  str1 = "";
          }
        String str2 = newTemp();
        if(!str1.equals(""))System.out.println(str2 + " = "+str1);
        temps.put(thisClass + "~" + thisMethod + "^" + str, str2);
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
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, (A)"cls");
      if(str.equals("int") || str.equals("bool"))
      {
    	  str = "i32";
      }
      else if(str.equals("arr"))
      {
    	  str = "i32*";
      }
      else
      {
    	  str = str;
      }
      thisMethod = (String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      tempx = 1;
      formPara = "";
      n.f4.accept(this, argu);
      System.out.println("define "+str+"@"+thisClass+"_"+" ( %"+thisClass+"* %this "+formPara+" ) nounwind {");
      formPara = "";
      tempx = 1;
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      String str1 = (String)n.f10.accept(this, argu); //++++
      n.f11.accept(this, argu);
      n.f12.accept(this, argu);
      System.out.println("ret "+str+" "+str1);
      System.out.println("}");
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
      String str1 = newTempx();
      String str2 = (String)n.f0.accept(this, (A)"cls");
      String str = (String)n.f1.accept(this, (A)"just");
      if(thisMethod.equals(""))
      {
        temps.put(thisClass + "~" + str, str1);
      }
      else
      {
        temps.put(thisClass + "~" + thisMethod + "^" + str, str1);
      }
      if(str2.equals("int") || str2.equals("bool"))
      {
    	  str2 = "i32";
      }
      else if(str2.equals("arr"))
      {
    	  str2 = "i32*";
      }
      else
      {
    	  str2 = str2;
      }
      formPara = formPara + ", " + str2 + " " + str1;
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
      //R _ret=null;
      String str = (String)n.f0.accept(this, argu);
      return (R)str;
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public R visit(ArrayType n, A argu) {
      //R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return (R)"arr";
   }

   /**
    * f0 -> "boolean"
    */
   public R visit(BooleanType n, A argu) {
      //R _ret=null;
      n.f0.accept(this, argu);
      return (R)"bool";
   }

   /**
    * f0 -> "int"
    */
   public R visit(IntegerType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)"int";
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
	       System.out.println("store i32 "+str+", i32* "+str1);
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
	     String strc = newTemp();
	     System.out.println(strc+" = getelementptr %"+thisClass+", %"+thisClass+"* %this, i32 0, i32 "+Integer.toString(y));
	     System.out.println("store i32 "+strc+", i32* "+str1);
	     //System.out.println("HSTORE PLUS TEMP 0 "+Integer.toString(4*(y+1))+" 0"+str1);
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
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
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
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
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
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
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
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
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
      n.f2.accept(this, argu);
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
      R _ret=null;
      String str = newTemp();
      String str1 = (String)n.f0.accept(this,argu);
      if(str1.indexOf("$") != -1) // ++++
      {
        return (R)str1;
      }
      System.out.println(str+" = load i32, i32* "+str1+", align 4");
      return (R)str;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "&&"
    * f2 -> PrimaryExpression()
    */
   public R visit(AndExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "||"
    * f2 -> PrimaryExpression()
    */
   public R visit(OrExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "<="
    * f2 -> PrimaryExpression()
    */
   public R visit(CompareExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "!="
    * f2 -> PrimaryExpression()
    */
   public R visit(neqExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "+"
    * f2 -> PrimaryExpression()
    */
   public R visit(PlusExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "-"
    * f2 -> PrimaryExpression()
    */
   public R visit(MinusExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "*"
    * f2 -> PrimaryExpression()
    */
   public R visit(TimesExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "/"
    * f2 -> PrimaryExpression()
    */
   public R visit(DivExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "["
    * f2 -> PrimaryExpression()
    * f3 -> "]"
    */
   public R visit(ArrayLookup n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> "length"
    */
   public R visit(ArrayLength n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
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
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> Expression()
    * f1 -> ( ExpressionRest() )*
    */
   public R visit(ExpressionList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Expression()
    */
   public R visit(ExpressionRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
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
      //R _ret=null;
      n.f0.accept(this, argu);
      return (R)" 1 ";
   }

   /**
    * f0 -> "false"
    */
   public R visit(FalseLiteral n, A argu) {
      //R _ret=null;
	   n.f0.accept(this, argu);
	      return (R)" 0 ";
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n, A argu) {
	   String str = (String) argu;
	     String _ret = n.f0.tokenImage;
	     String str2 = "";
	     if(str.equals("just"))
	     {
	       return (R)_ret;
	     }
	     if(str.equals("cls"))
	     {
	    	 return (R)("%"+_ret);
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
	         System.out.println(str2+" = getelementptr %"+thisClass+", "+thisClass+"* %this, i32 0, i32 "+Integer.toString(y));
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
	 //R _ret=null; ++++
	      n.f0.accept(this, argu);
	      String str = (String)argu;
	      if(str.equals("class"))
	      {
	        return (R)(thisClass+"$ %this ");
	      }
	      return (R)" %this ";
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
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      String str = (String)n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      String str1 = newTemp();
      System.out.println(str1+" = alloca i32, i32 "+str);
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
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, (A)"cls");
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      String str1 = newTemp();
      System.out.println(str1+" = alloca "+str);
      return (R)str1;
   }

   /**
    * f0 -> "!"
    * f1 -> Expression()
    */
   public R visit(NotExpression n, A argu) {
      //R _ret=null;
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, argu);
      String str1 = newTemp();
      System.out.println(str1+" = icmp ne i32 "+str+" , 1");
      return (R)str1;
   }

   /**
    * f0 -> "("
    * f1 -> Expression()
    * f2 -> ")"
    */
   public R visit(BracketExpression n, A argu) {
      //R _ret=null;
      n.f0.accept(this, argu);
      String str = (String)n.f1.accept(this, argu);
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
