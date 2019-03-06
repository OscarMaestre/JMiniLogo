/* The following code was generated by JFlex 1.7.0 */

package io.github.oscarmaestre.jminilogo;
import java_cup.runtime.Symbol;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Lexer.es</tt>
 */
public class Lexer implements java_cup.runtime.Scanner, sym {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int NO_IGNORAR_ESPACIOS = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\40\1\40\1\0\1\40\1\40\22\0\1\40\7\0\1\42"+
    "\1\43\1\35\1\34\1\41\1\31\1\0\1\36\1\32\11\33\1\0"+
    "\1\27\1\0\1\37\3\0\32\23\6\0\1\6\1\22\1\17\1\16"+
    "\1\2\1\23\1\3\1\23\1\21\1\12\1\23\1\11\1\13\1\1"+
    "\1\5\1\26\1\23\1\4\1\30\1\14\1\10\1\15\2\23\1\20"+
    "\1\7\1\24\1\0\1\25\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\12\2\1\3\1\4\1\2\1\5\1\2"+
    "\1\6\2\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\40\2\1\21\1\2\1\22\1\23"+
    "\4\2\1\24\4\2\1\25\5\2\1\26\7\2\1\27"+
    "\2\2\1\30\3\2\1\31\1\2\1\32\3\2\1\33"+
    "\1\34\3\2\1\35\1\2\1\36\4\2\1\37";

  private static int [] zzUnpackAction() {
    int [] result = new int[115];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\44\0\110\0\154\0\220\0\264\0\330\0\374"+
    "\0\u0120\0\u0144\0\u0168\0\u018c\0\u01b0\0\110\0\110\0\u01d4"+
    "\0\110\0\u01f8\0\u021c\0\110\0\u0240\0\110\0\110\0\110"+
    "\0\110\0\u0264\0\110\0\110\0\110\0\u0288\0\u02ac\0\u02d0"+
    "\0\u02f4\0\u0318\0\u033c\0\u0360\0\u0384\0\u03a8\0\u03cc\0\u03f0"+
    "\0\u0414\0\u0438\0\u045c\0\u0480\0\u04a4\0\u04c8\0\u04ec\0\u0510"+
    "\0\u0534\0\u0558\0\u057c\0\u05a0\0\u05c4\0\u05e8\0\u060c\0\u0630"+
    "\0\u0654\0\u0678\0\u069c\0\u06c0\0\u06e4\0\u0708\0\374\0\u072c"+
    "\0\374\0\374\0\u0750\0\u0774\0\u0798\0\u07bc\0\374\0\u07e0"+
    "\0\u0804\0\u0828\0\u084c\0\374\0\u0870\0\u0894\0\u08b8\0\u08dc"+
    "\0\u0900\0\374\0\u0924\0\u0948\0\u096c\0\u0990\0\u09b4\0\u09d8"+
    "\0\u09fc\0\374\0\u0a20\0\u0a44\0\374\0\u0a68\0\u0a8c\0\u0ab0"+
    "\0\374\0\u0ad4\0\374\0\u0af8\0\u0b1c\0\u0b40\0\374\0\374"+
    "\0\u0b64\0\u0b88\0\u0bac\0\374\0\u0bd0\0\374\0\u0bf4\0\u0c18"+
    "\0\u0c3c\0\u0c60\0\u0c84";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[115];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\4\10"+
    "\1\12\1\10\1\13\1\10\1\14\2\10\1\15\1\10"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\4\10"+
    "\1\12\1\10\1\13\1\10\1\14\2\10\1\15\1\10"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\36\1\33\1\34\1\35"+
    "\45\0\1\10\1\37\21\10\2\0\1\10\1\0\1\10"+
    "\14\0\11\10\1\40\11\10\2\0\1\10\1\0\1\10"+
    "\14\0\20\10\1\41\2\10\2\0\1\10\1\0\1\10"+
    "\14\0\1\10\1\42\2\10\1\43\16\10\2\0\1\10"+
    "\1\0\1\10\14\0\23\10\2\0\1\10\1\0\1\10"+
    "\14\0\6\10\1\44\3\10\1\45\1\10\1\46\6\10"+
    "\2\0\1\10\1\0\1\10\14\0\5\10\1\47\15\10"+
    "\2\0\1\10\1\0\1\10\14\0\1\10\1\50\21\10"+
    "\2\0\1\10\1\0\1\10\14\0\17\10\1\51\3\10"+
    "\2\0\1\10\1\0\1\10\14\0\5\10\1\52\2\10"+
    "\1\53\12\10\2\0\1\10\1\0\1\10\14\0\3\10"+
    "\1\54\17\10\2\0\1\10\1\0\1\10\14\0\7\10"+
    "\1\55\13\10\2\0\1\10\1\0\1\10\45\0\1\24"+
    "\1\25\42\0\2\25\50\0\1\32\43\0\1\36\4\0"+
    "\2\10\1\56\20\10\2\0\1\10\1\0\1\10\14\0"+
    "\1\10\1\57\21\10\2\0\1\10\1\0\1\10\14\0"+
    "\3\10\1\60\17\10\2\0\1\10\1\0\1\10\14\0"+
    "\23\10\2\0\1\61\1\0\1\10\14\0\11\10\1\62"+
    "\11\10\2\0\1\10\1\0\1\10\14\0\7\10\1\63"+
    "\13\10\2\0\1\10\1\0\1\10\14\0\5\10\1\64"+
    "\15\10\2\0\1\10\1\0\1\10\14\0\5\10\1\65"+
    "\15\10\2\0\1\10\1\0\1\10\14\0\2\10\1\66"+
    "\20\10\2\0\1\10\1\0\1\10\14\0\3\10\1\67"+
    "\17\10\2\0\1\10\1\0\1\10\14\0\5\10\1\70"+
    "\15\10\2\0\1\10\1\0\1\10\14\0\11\10\1\71"+
    "\11\10\2\0\1\10\1\0\1\10\14\0\5\10\1\72"+
    "\15\10\2\0\1\10\1\0\1\10\14\0\4\10\1\73"+
    "\16\10\2\0\1\10\1\0\1\10\14\0\21\10\1\74"+
    "\1\10\2\0\1\10\1\0\1\10\14\0\3\10\1\75"+
    "\17\10\2\0\1\10\1\0\1\10\14\0\16\10\1\76"+
    "\4\10\2\0\1\10\1\0\1\10\14\0\5\10\1\77"+
    "\15\10\2\0\1\10\1\0\1\10\14\0\1\10\1\100"+
    "\21\10\2\0\1\10\1\0\1\10\14\0\4\10\1\101"+
    "\16\10\2\0\1\10\1\0\1\10\14\0\10\10\1\102"+
    "\12\10\2\0\1\10\1\0\1\10\14\0\3\10\1\103"+
    "\17\10\2\0\1\10\1\0\1\10\14\0\1\104\22\10"+
    "\2\0\1\10\1\0\1\10\14\0\1\10\1\105\21\10"+
    "\2\0\1\10\1\0\1\10\14\0\15\10\1\106\5\10"+
    "\2\0\1\10\1\0\1\10\14\0\1\107\22\10\2\0"+
    "\1\10\1\0\1\10\14\0\5\10\1\110\15\10\2\0"+
    "\1\10\1\0\1\10\14\0\1\111\22\10\2\0\1\10"+
    "\1\0\1\10\14\0\16\10\1\112\4\10\2\0\1\10"+
    "\1\0\1\10\14\0\1\10\1\113\21\10\2\0\1\10"+
    "\1\0\1\10\14\0\4\10\1\114\16\10\2\0\1\10"+
    "\1\0\1\10\14\0\7\10\1\115\13\10\2\0\1\10"+
    "\1\0\1\10\14\0\13\10\1\116\7\10\2\0\1\10"+
    "\1\0\1\10\14\0\20\10\1\117\2\10\2\0\1\10"+
    "\1\0\1\10\14\0\6\10\1\120\14\10\2\0\1\10"+
    "\1\0\1\10\14\0\1\121\22\10\2\0\1\10\1\0"+
    "\1\10\14\0\1\10\1\122\21\10\2\0\1\10\1\0"+
    "\1\10\14\0\10\10\1\123\12\10\2\0\1\10\1\0"+
    "\1\10\14\0\16\10\1\124\4\10\2\0\1\10\1\0"+
    "\1\10\14\0\1\10\1\125\21\10\2\0\1\10\1\0"+
    "\1\10\14\0\10\10\1\126\12\10\2\0\1\10\1\0"+
    "\1\10\14\0\13\10\1\127\7\10\2\0\1\10\1\0"+
    "\1\10\14\0\20\10\1\130\2\10\2\0\1\10\1\0"+
    "\1\10\14\0\10\10\1\131\12\10\2\0\1\10\1\0"+
    "\1\10\14\0\5\10\1\132\15\10\2\0\1\10\1\0"+
    "\1\10\14\0\13\10\1\133\7\10\2\0\1\10\1\0"+
    "\1\10\14\0\5\10\1\134\15\10\2\0\1\10\1\0"+
    "\1\10\14\0\4\10\1\135\16\10\2\0\1\10\1\0"+
    "\1\10\14\0\15\10\1\136\5\10\2\0\1\10\1\0"+
    "\1\10\14\0\5\10\1\137\15\10\2\0\1\10\1\0"+
    "\1\10\14\0\5\10\1\140\15\10\2\0\1\10\1\0"+
    "\1\10\14\0\3\10\1\141\17\10\2\0\1\10\1\0"+
    "\1\10\14\0\10\10\1\142\12\10\2\0\1\10\1\0"+
    "\1\10\14\0\5\10\1\143\15\10\2\0\1\10\1\0"+
    "\1\10\14\0\23\10\2\0\1\144\1\0\1\10\14\0"+
    "\20\10\1\145\2\10\2\0\1\10\1\0\1\10\14\0"+
    "\23\10\2\0\1\146\1\0\1\10\14\0\3\10\1\147"+
    "\17\10\2\0\1\10\1\0\1\10\14\0\4\10\1\150"+
    "\16\10\2\0\1\10\1\0\1\10\14\0\20\10\1\151"+
    "\2\10\2\0\1\10\1\0\1\10\14\0\12\10\1\152"+
    "\10\10\2\0\1\10\1\0\1\10\14\0\20\10\1\153"+
    "\2\10\2\0\1\10\1\0\1\10\14\0\6\10\1\154"+
    "\14\10\2\0\1\10\1\0\1\10\14\0\20\10\1\155"+
    "\2\10\2\0\1\10\1\0\1\10\14\0\6\10\1\156"+
    "\14\10\2\0\1\10\1\0\1\10\14\0\1\10\1\157"+
    "\21\10\2\0\1\10\1\0\1\10\14\0\1\160\22\10"+
    "\2\0\1\10\1\0\1\10\14\0\13\10\1\161\7\10"+
    "\2\0\1\10\1\0\1\10\14\0\4\10\1\162\16\10"+
    "\2\0\1\10\1\0\1\10\14\0\23\10\2\0\1\10"+
    "\1\0\1\10\7\0\1\163\43\0\1\163\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3240];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\12\1\2\11\1\1\1\11\2\1\1\11"+
    "\1\1\4\11\1\1\3\11\126\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[115];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
      boolean DEPURANDO = true;
      StringBuffer string = new StringBuffer();

      private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
      }
      private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
      }
      public void init(){
      }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 142) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Simbolo no esperado <"+
                                                        yytext()+">");
            } 
            // fall through
          case 32: break;
          case 2: 
            { if (DEPURANDO){
                                        System.out.println("Encontrado -IDENTIFICADOr-"+yytext());
                                        System.out.println("Estabamos en el estado:"+yystate());
                                    }
                                    return symbol (sym.IDENTIFICADOR, new String(yytext()));
            } 
            // fall through
          case 33: break;
          case 3: 
            { return symbol (sym.LLAVEABIERTA);
            } 
            // fall through
          case 34: break;
          case 4: 
            { return symbol (sym.LLAVECERRADA);
            } 
            // fall through
          case 35: break;
          case 5: 
            { if (DEPURANDO){
                                System.out.println("Encontrando -Punto y coma-"+yytext());  
                                System.out.println("Estabamos en el estado:"+yystate());
                            }
                            yybegin(YYINITIAL);return symbol (sym.PUNTOCOMA);
            } 
            // fall through
          case 36: break;
          case 6: 
            { return symbol (sym.RESTA);
            } 
            // fall through
          case 37: break;
          case 7: 
            { yybegin(YYINITIAL); 
                                        if (DEPURANDO){
                                            System.out.println("Encontrando -Entero-"+yytext());
                                        }
                                        return symbol (sym.ENTERO, new String(yytext()));
            } 
            // fall through
          case 38: break;
          case 8: 
            { return symbol (sym.SUMA);
            } 
            // fall through
          case 39: break;
          case 9: 
            { return symbol (sym.MULTIPLICACION);
            } 
            // fall through
          case 40: break;
          case 10: 
            { return symbol (sym.DIVISION);
            } 
            // fall through
          case 41: break;
          case 11: 
            { return symbol (sym.IGUAL);
            } 
            // fall through
          case 42: break;
          case 12: 
            { if (DEPURANDO){
                                            System.out.println("Encontrando -espacio que ignorar-"+yytext());
                                        }
                                        
                                        /* En este estado ignoramos los espacios en blanco*/
            } 
            // fall through
          case 43: break;
          case 13: 
            { return symbol (sym.COMA);
            } 
            // fall through
          case 44: break;
          case 14: 
            { return symbol (sym.PARENIZQ);
            } 
            // fall through
          case 45: break;
          case 15: 
            { return symbol (sym.PARENDER);
            } 
            // fall through
          case 46: break;
          case 16: 
            { if (DEPURANDO){
                                            System.out.println("Encontrando -espacio que NO IGNORAMOS-"+yytext());
                                        }
                                        return symbol (sym.ESPACIO);
            } 
            // fall through
          case 47: break;
          case 17: 
            { if (DEPURANDO){
                                            System.out.println("Encontrando -gira-, aceptando espacios...");
                                        }
                                        yybegin(NO_IGNORAR_ESPACIOS); 
                                        return symbol (sym.GIRA);
            } 
            // fall through
          case 48: break;
          case 18: 
            { if (DEPURANDO){
                                        System.out.println("Encontrado -rojo-");
                                        System.out.println("Estabamos en el estado:"+yystate());
                                    }
                                    return symbol (sym.ROJO);
            } 
            // fall through
          case 49: break;
          case 19: 
            { if (DEPURANDO){
                                        System.out.println("Encontrado -azul-");
                                        System.out.println("Estabamos en el estado:"+yystate());
                                    }
                                    return symbol (sym.AZUL);
            } 
            // fall through
          case 50: break;
          case 20: 
            { return symbol (sym.CYAN);
            } 
            // fall through
          case 51: break;
          case 21: 
            { if (DEPURANDO){
                                        System.out.println("Encontrado -negro-");
                                        System.out.println("Estabamos en el estado:"+yystate());
                                    }
                                    return symbol (sym.NEGRO);
            } 
            // fall through
          case 52: break;
          case 22: 
            { return symbol (sym.VERDE);
            } 
            // fall through
          case 53: break;
          case 23: 
            { if (DEPURANDO){
                                            System.out.println("Encontrando -avanza-, aceptando espacios...");
                                        }
                                        yybegin(NO_IGNORAR_ESPACIOS); 
                                        return symbol (sym.AVANZA);
            } 
            // fall through
          case 54: break;
          case 24: 
            { return symbol (sym.BLANCO);
            } 
            // fall through
          case 55: break;
          case 25: 
            { if (DEPURANDO){
                                            System.out.println("Encontrando -repetir-, aceptando espacios...");
                                        }
                                        yybegin(NO_IGNORAR_ESPACIOS); 
                                        return symbol (sym.REPETIR);
            } 
            // fall through
          case 56: break;
          case 26: 
            { return symbol (sym.MAGENTA);
            } 
            // fall through
          case 57: break;
          case 27: 
            { if (DEPURANDO){
                                            System.out.println("Encontrando -EJECUTAR-");
                                        }
                                    return symbol (sym.EJECUTAR);
            } 
            // fall through
          case 58: break;
          case 28: 
            { return symbol (sym.AMARILLO);
            } 
            // fall through
          case 59: break;
          case 29: 
            { if (DEPURANDO){
                                            System.out.println("Encontrando -bajalapiz-");
                                        }
                                        return symbol (sym.BAJALAPIZ);
            } 
            // fall through
          case 60: break;
          case 30: 
            { if (DEPURANDO){
                                            System.out.println("Encontrando -subelapiz-");
                                        }
                                        return symbol (sym.SUBELAPIZ);
            } 
            // fall through
          case 61: break;
          case 31: 
            { return symbol (sym.PROCEDIMIENTO);
            } 
            // fall through
          case 62: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
