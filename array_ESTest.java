/*
 * This file was automatically generated by EvoSuite
 * Mon Jul 03 03:04:54 GMT 2017
 */


import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.util.SystemInUtil;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class array_ESTest extends array_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      String[] stringArray0 = new String[8];
      SystemInUtil.addInputLine("U+(");
      // Undeclared exception!
      try { 
        array.main(stringArray0);
        fail("Expecting exception: InputMismatchException");
      
      } catch(InputMismatchException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      SystemInUtil.addInputLine("-1");
      // Undeclared exception!
      try { 
        array.main((String[]) null);
        fail("Expecting exception: NegativeArraySizeException");
      
      } catch(NegativeArraySizeException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("array", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      SystemInUtil.addInputLine("1");
      SystemInUtil.addInputLine("1");
      SystemInUtil.addInputLine("*");
      // Undeclared exception!
      try { 
        array.main((String[]) null);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 1
         //
         assertThrownBy("array", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      SystemInUtil.addInputLine("0");
      SystemInUtil.addInputLine("+");
      String[] stringArray0 = new String[4];
      array.main(stringArray0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      SystemInUtil.addInputLine("1");
      SystemInUtil.addInputLine("1");
      SystemInUtil.addInputLine(",");
      array.main((String[]) null);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      SystemInUtil.addInputLine("0");
      SystemInUtil.addInputLine("*");
      String[] stringArray0 = new String[5];
      array.main(stringArray0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      SystemInUtil.addInputLine("1");
      SystemInUtil.addInputLine("1");
      SystemInUtil.addInputLine("+");
      String[] stringArray0 = new String[6];
      // Undeclared exception!
      try { 
        array.main(stringArray0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 1
         //
         assertThrownBy("array", e);
      }
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      SystemInUtil.addInputLine("1");
      // Undeclared exception!
      try { 
        array.main((String[]) null);
        fail("Expecting exception: NoSuchElementException");
      
      } catch(NoSuchElementException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("java.util.Scanner", e);
      }
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      array array0 = new array();
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      SystemInUtil.addInputLine("0");
      SystemInUtil.addInputLine("-");
      String[] stringArray0 = new String[9];
      // Undeclared exception!
      try { 
        array.main(stringArray0);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // 2
         //
         assertThrownBy("array", e);
      }
  }
}
