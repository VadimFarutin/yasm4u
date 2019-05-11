// Generated from C:/Users/Vadim/Documents/IdeaProjects/yasm4u/core/src/main/resources/sql.antlr\SQLParser.g4 by ANTLR 4.7.2
package com.expleague.yasm4u.domains.sql.parser.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SPACE=1, ALL=2, AND=3, AS=4, ASC=5, BY=6, CROSS=7, DESC=8, DISTINCT=9, 
		FALSE=10, FROM=11, GROUP=12, HAVING=13, IN=14, INNER=15, IS=16, JOIN=17, 
		LIMIT=18, NOT=19, NULL_LITERAL=20, ON=21, OR=22, ORDER=23, OUTER=24, RIGHT=25, 
		SELECT=26, TRUE=27, UNION=28, UNIQUE=29, WHERE=30, WITH=31, AVG=32, COUNT=33, 
		MAX=34, MIN=35, SUM=36, ABS=37, CEILING=38, FLOOR=39, STAR=40, DIVIDE=41, 
		MODULE=42, PLUS=43, MINUS=44, EQUAL_SYMBOL=45, GREATER_SYMBOL=46, LESS_SYMBOL=47, 
		EXCLAMATION_SYMBOL=48, DOT=49, LR_BRACKET=50, RR_BRACKET=51, COMMA=52, 
		SEMI=53, SINGLE_QUOTE_SYMB=54, DOUBLE_QUOTE_SYMB=55, STRING_LITERAL=56, 
		DECIMAL_LITERAL=57, ID=58, DQUOTA_STRING=59, SQUOTA_STRING=60, DEC_DIGIT=61, 
		ERROR_RECONGNIGION=62;
	public static final int
		RULE_sqlStatement = 0, RULE_selectStatement = 1, RULE_querySpecification = 2, 
		RULE_orderByClause = 3, RULE_tableSources = 4, RULE_tableSourceItem = 5, 
		RULE_joinPart = 6, RULE_unionStatement = 7, RULE_selectSpec = 8, RULE_selectElements = 9, 
		RULE_selectElement = 10, RULE_fromClause = 11, RULE_groupByItem = 12, 
		RULE_limitClause = 13, RULE_tableName = 14, RULE_fullColumnName = 15, 
		RULE_uid = 16, RULE_decimalLiteral = 17, RULE_stringLiteral = 18, RULE_booleanLiteral = 19, 
		RULE_nullNotnull = 20, RULE_constant = 21, RULE_functionCall = 22, RULE_aggregateWindowedFunction = 23, 
		RULE_functionArgs = 24, RULE_functionArg = 25, RULE_expression = 26, RULE_predicate = 27, 
		RULE_expressionAtom = 28, RULE_comparisonOperator = 29, RULE_logicalOperator = 30, 
		RULE_mathOperator = 31, RULE_functionNameBase = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"sqlStatement", "selectStatement", "querySpecification", "orderByClause", 
			"tableSources", "tableSourceItem", "joinPart", "unionStatement", "selectSpec", 
			"selectElements", "selectElement", "fromClause", "groupByItem", "limitClause", 
			"tableName", "fullColumnName", "uid", "decimalLiteral", "stringLiteral", 
			"booleanLiteral", "nullNotnull", "constant", "functionCall", "aggregateWindowedFunction", 
			"functionArgs", "functionArg", "expression", "predicate", "expressionAtom", 
			"comparisonOperator", "logicalOperator", "mathOperator", "functionNameBase"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'ALL'", "'AND'", "'AS'", "'ASC'", "'BY'", "'CROSS'", "'DESC'", 
			"'DISTINCT'", "'FALSE'", "'FROM'", "'GROUP'", "'HAVING'", "'IN'", "'INNER'", 
			"'IS'", "'JOIN'", "'LIMIT'", "'NOT'", "'NULL'", "'ON'", "'OR'", "'ORDER'", 
			"'OUTER'", "'RIGHT'", "'SELECT'", "'TRUE'", "'UNION'", "'UNIQUE'", "'WHERE'", 
			"'WITH'", "'AVG'", "'COUNT'", "'MAX'", "'MIN'", "'SUM'", "'ABS'", "'CEILING'", 
			"'FLOOR'", "'*'", "'/'", "'%'", "'+'", "'-'", "'='", "'>'", "'<'", "'!'", 
			"'.'", "'('", "')'", "','", "';'", "'''", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SPACE", "ALL", "AND", "AS", "ASC", "BY", "CROSS", "DESC", "DISTINCT", 
			"FALSE", "FROM", "GROUP", "HAVING", "IN", "INNER", "IS", "JOIN", "LIMIT", 
			"NOT", "NULL_LITERAL", "ON", "OR", "ORDER", "OUTER", "RIGHT", "SELECT", 
			"TRUE", "UNION", "UNIQUE", "WHERE", "WITH", "AVG", "COUNT", "MAX", "MIN", 
			"SUM", "ABS", "CEILING", "FLOOR", "STAR", "DIVIDE", "MODULE", "PLUS", 
			"MINUS", "EQUAL_SYMBOL", "GREATER_SYMBOL", "LESS_SYMBOL", "EXCLAMATION_SYMBOL", 
			"DOT", "LR_BRACKET", "RR_BRACKET", "COMMA", "SEMI", "SINGLE_QUOTE_SYMB", 
			"DOUBLE_QUOTE_SYMB", "STRING_LITERAL", "DECIMAL_LITERAL", "ID", "DQUOTA_STRING", 
			"SQUOTA_STRING", "DEC_DIGIT", "ERROR_RECONGNIGION"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SQLParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SqlStatementContext extends ParserRuleContext {
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SQLParser.SEMI, 0); }
		public SqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSqlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSqlStatement(this);
		}
	}

	public final SqlStatementContext sqlStatement() throws RecognitionException {
		SqlStatementContext _localctx = new SqlStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sqlStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			selectStatement();
			setState(67);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectStatementContext extends ParserRuleContext {
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
	 
		public SelectStatementContext() { }
		public void copyFrom(SelectStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnionSelectContext extends SelectStatementContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public List<UnionStatementContext> unionStatement() {
			return getRuleContexts(UnionStatementContext.class);
		}
		public UnionStatementContext unionStatement(int i) {
			return getRuleContext(UnionStatementContext.class,i);
		}
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public LimitClauseContext limitClause() {
			return getRuleContext(LimitClauseContext.class,0);
		}
		public UnionSelectContext(SelectStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnionSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnionSelect(this);
		}
	}
	public static class SimpleSelectContext extends SelectStatementContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public SimpleSelectContext(SelectStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSimpleSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSimpleSelect(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectStatement);
		int _la;
		try {
			int _alt;
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SimpleSelectContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				querySpecification();
				}
				break;
			case 2:
				_localctx = new UnionSelectContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				querySpecification();
				setState(72); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(71);
						unionStatement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(74); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UNION) {
					{
					setState(76);
					unionStatement();
					}
				}

				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(79);
					orderByClause();
					}
				}

				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LIMIT) {
					{
					setState(82);
					limitClause();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public SelectElementsContext selectElements() {
			return getRuleContext(SelectElementsContext.class,0);
		}
		public List<SelectSpecContext> selectSpec() {
			return getRuleContexts(SelectSpecContext.class);
		}
		public SelectSpecContext selectSpec(int i) {
			return getRuleContext(SelectSpecContext.class,i);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public LimitClauseContext limitClause() {
			return getRuleContext(LimitClauseContext.class,0);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitQuerySpecification(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(SELECT);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALL || _la==DISTINCT) {
				{
				{
				setState(88);
				selectSpec();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			selectElements();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(95);
				fromClause();
				}
			}

			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(98);
				orderByClause();
				}
				break;
			}
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(101);
				limitClause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderByClauseContext extends ParserRuleContext {
		public Token order;
		public TerminalNode ORDER() { return getToken(SQLParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASC() { return getToken(SQLParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SQLParser.DESC, 0); }
		public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitOrderByClause(this);
		}
	}

	public final OrderByClauseContext orderByClause() throws RecognitionException {
		OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_orderByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(ORDER);
			setState(105);
			match(BY);
			setState(106);
			expression(0);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(107);
				((OrderByClauseContext)_localctx).order = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((OrderByClauseContext)_localctx).order = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableSourcesContext extends ParserRuleContext {
		public List<TableSourceItemContext> tableSourceItem() {
			return getRuleContexts(TableSourceItemContext.class);
		}
		public TableSourceItemContext tableSourceItem(int i) {
			return getRuleContext(TableSourceItemContext.class,i);
		}
		public List<JoinPartContext> joinPart() {
			return getRuleContexts(JoinPartContext.class);
		}
		public JoinPartContext joinPart(int i) {
			return getRuleContext(JoinPartContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TableSourcesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableSources; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTableSources(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTableSources(this);
		}
	}

	public final TableSourcesContext tableSources() throws RecognitionException {
		TableSourcesContext _localctx = new TableSourcesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tableSources);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			tableSourceItem();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CROSS) | (1L << INNER) | (1L << JOIN))) != 0)) {
				{
				{
				setState(111);
				joinPart();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(117);
				match(COMMA);
				setState(118);
				tableSourceItem();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CROSS) | (1L << INNER) | (1L << JOIN))) != 0)) {
					{
					{
					setState(119);
					joinPart();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableSourceItemContext extends ParserRuleContext {
		public TableSourceItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableSourceItem; }
	 
		public TableSourceItemContext() { }
		public void copyFrom(TableSourceItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryTableItemContext extends TableSourceItemContext {
		public SelectStatementContext parenthesisSubquery;
		public UidContext alias;
		public TerminalNode LR_BRACKET() { return getToken(SQLParser.LR_BRACKET, 0); }
		public TerminalNode RR_BRACKET() { return getToken(SQLParser.RR_BRACKET, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public UidContext uid() {
			return getRuleContext(UidContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public SubqueryTableItemContext(TableSourceItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSubqueryTableItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSubqueryTableItem(this);
		}
	}
	public static class AtomTableItemContext extends TableSourceItemContext {
		public UidContext alias;
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public UidContext uid() {
			return getRuleContext(UidContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public AtomTableItemContext(TableSourceItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAtomTableItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAtomTableItem(this);
		}
	}
	public static class TableSourcesItemContext extends TableSourceItemContext {
		public TerminalNode LR_BRACKET() { return getToken(SQLParser.LR_BRACKET, 0); }
		public TableSourcesContext tableSources() {
			return getRuleContext(TableSourcesContext.class,0);
		}
		public TerminalNode RR_BRACKET() { return getToken(SQLParser.RR_BRACKET, 0); }
		public TableSourcesItemContext(TableSourceItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTableSourcesItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTableSourcesItem(this);
		}
	}

	public final TableSourceItemContext tableSourceItem() throws RecognitionException {
		TableSourceItemContext _localctx = new TableSourceItemContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tableSourceItem);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new AtomTableItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				tableName();
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << AVG) | (1L << COUNT) | (1L << MAX) | (1L << MIN) | (1L << SUM) | (1L << ID))) != 0)) {
					{
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(131);
						match(AS);
						}
					}

					setState(134);
					((AtomTableItemContext)_localctx).alias = uid();
					}
				}

				}
				break;
			case 2:
				_localctx = new SubqueryTableItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(LR_BRACKET);
				setState(138);
				((SubqueryTableItemContext)_localctx).parenthesisSubquery = selectStatement();
				setState(139);
				match(RR_BRACKET);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(140);
					match(AS);
					}
				}

				setState(143);
				((SubqueryTableItemContext)_localctx).alias = uid();
				}
				break;
			case 3:
				_localctx = new TableSourcesItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				match(LR_BRACKET);
				setState(146);
				tableSources();
				setState(147);
				match(RR_BRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinPartContext extends ParserRuleContext {
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public TableSourceItemContext tableSourceItem() {
			return getRuleContext(TableSourceItemContext.class,0);
		}
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INNER() { return getToken(SQLParser.INNER, 0); }
		public TerminalNode CROSS() { return getToken(SQLParser.CROSS, 0); }
		public JoinPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterJoinPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitJoinPart(this);
		}
	}

	public final JoinPartContext joinPart() throws RecognitionException {
		JoinPartContext _localctx = new JoinPartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_joinPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CROSS || _la==INNER) {
				{
				setState(151);
				_la = _input.LA(1);
				if ( !(_la==CROSS || _la==INNER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(154);
			match(JOIN);
			setState(155);
			tableSourceItem();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(156);
				match(ON);
				setState(157);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionStatementContext extends ParserRuleContext {
		public Token unionType;
		public TerminalNode UNION() { return getToken(SQLParser.UNION, 0); }
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode DISTINCT() { return getToken(SQLParser.DISTINCT, 0); }
		public UnionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUnionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUnionStatement(this);
		}
	}

	public final UnionStatementContext unionStatement() throws RecognitionException {
		UnionStatementContext _localctx = new UnionStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(UNION);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(161);
				((UnionStatementContext)_localctx).unionType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ALL || _la==DISTINCT) ) {
					((UnionStatementContext)_localctx).unionType = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(164);
			querySpecification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectSpecContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode DISTINCT() { return getToken(SQLParser.DISTINCT, 0); }
		public SelectSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelectSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelectSpec(this);
		}
	}

	public final SelectSpecContext selectSpec() throws RecognitionException {
		SelectSpecContext _localctx = new SelectSpecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_selectSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectElementsContext extends ParserRuleContext {
		public Token star;
		public List<SelectElementContext> selectElement() {
			return getRuleContexts(SelectElementContext.class);
		}
		public SelectElementContext selectElement(int i) {
			return getRuleContext(SelectElementContext.class,i);
		}
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public SelectElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelectElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelectElements(this);
		}
	}

	public final SelectElementsContext selectElements() throws RecognitionException {
		SelectElementsContext _localctx = new SelectElementsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_selectElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(168);
				((SelectElementsContext)_localctx).star = match(STAR);
				}
				break;
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
			case ID:
				{
				setState(169);
				selectElement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(172);
				match(COMMA);
				setState(173);
				selectElement();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectElementContext extends ParserRuleContext {
		public SelectElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectElement; }
	 
		public SelectElementContext() { }
		public void copyFrom(SelectElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectFunctionElementContext extends SelectElementContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public UidContext uid() {
			return getRuleContext(UidContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public SelectFunctionElementContext(SelectElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelectFunctionElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelectFunctionElement(this);
		}
	}
	public static class SelectStarElementContext extends SelectElementContext {
		public UidContext uid() {
			return getRuleContext(UidContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public SelectStarElementContext(SelectElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelectStarElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelectStarElement(this);
		}
	}
	public static class SelectColumnElementContext extends SelectElementContext {
		public FullColumnNameContext fullColumnName() {
			return getRuleContext(FullColumnNameContext.class,0);
		}
		public UidContext uid() {
			return getRuleContext(UidContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public SelectColumnElementContext(SelectElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSelectColumnElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSelectColumnElement(this);
		}
	}

	public final SelectElementContext selectElement() throws RecognitionException {
		SelectElementContext _localctx = new SelectElementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_selectElement);
		int _la;
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new SelectStarElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				uid();
				setState(180);
				match(DOT);
				setState(181);
				match(STAR);
				}
				break;
			case 2:
				_localctx = new SelectColumnElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				fullColumnName();
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << AVG) | (1L << COUNT) | (1L << MAX) | (1L << MIN) | (1L << SUM) | (1L << ID))) != 0)) {
					{
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(184);
						match(AS);
						}
					}

					setState(187);
					uid();
					}
				}

				}
				break;
			case 3:
				_localctx = new SelectFunctionElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				functionCall();
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS) | (1L << AVG) | (1L << COUNT) | (1L << MAX) | (1L << MIN) | (1L << SUM) | (1L << ID))) != 0)) {
					{
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(191);
						match(AS);
						}
					}

					setState(194);
					uid();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClauseContext extends ParserRuleContext {
		public ExpressionContext whereExpr;
		public ExpressionContext havingExpr;
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public TableSourcesContext tableSources() {
			return getRuleContext(TableSourcesContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public TerminalNode GROUP() { return getToken(SQLParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public List<GroupByItemContext> groupByItem() {
			return getRuleContexts(GroupByItemContext.class);
		}
		public GroupByItemContext groupByItem(int i) {
			return getRuleContext(GroupByItemContext.class,i);
		}
		public TerminalNode HAVING() { return getToken(SQLParser.HAVING, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFromClause(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(FROM);
			setState(200);
			tableSources();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(201);
				match(WHERE);
				setState(202);
				((FromClauseContext)_localctx).whereExpr = expression(0);
				}
			}

			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(205);
				match(GROUP);
				setState(206);
				match(BY);
				setState(207);
				groupByItem();
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(208);
					match(COMMA);
					setState(209);
					groupByItem();
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(217);
				match(HAVING);
				setState(218);
				((FromClauseContext)_localctx).havingExpr = expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupByItemContext extends ParserRuleContext {
		public Token order;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASC() { return getToken(SQLParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SQLParser.DESC, 0); }
		public GroupByItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterGroupByItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitGroupByItem(this);
		}
	}

	public final GroupByItemContext groupByItem() throws RecognitionException {
		GroupByItemContext _localctx = new GroupByItemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_groupByItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			expression(0);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(222);
				((GroupByItemContext)_localctx).order = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((GroupByItemContext)_localctx).order = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitClauseContext extends ParserRuleContext {
		public DecimalLiteralContext limit;
		public TerminalNode LIMIT() { return getToken(SQLParser.LIMIT, 0); }
		public DecimalLiteralContext decimalLiteral() {
			return getRuleContext(DecimalLiteralContext.class,0);
		}
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitLimitClause(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_limitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(LIMIT);
			setState(226);
			((LimitClauseContext)_localctx).limit = decimalLiteral();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableNameContext extends ParserRuleContext {
		public UidContext uid() {
			return getRuleContext(UidContext.class,0);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitTableName(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			uid();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullColumnNameContext extends ParserRuleContext {
		public UidContext uid() {
			return getRuleContext(UidContext.class,0);
		}
		public FullColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullColumnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFullColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFullColumnName(this);
		}
	}

	public final FullColumnNameContext fullColumnName() throws RecognitionException {
		FullColumnNameContext _localctx = new FullColumnNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fullColumnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			uid();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UidContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public FunctionNameBaseContext functionNameBase() {
			return getRuleContext(FunctionNameBaseContext.class,0);
		}
		public UidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUid(this);
		}
	}

	public final UidContext uid() throws RecognitionException {
		UidContext _localctx = new UidContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_uid);
		try {
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(ID);
				}
				break;
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				functionNameBase();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecimalLiteralContext extends ParserRuleContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(SQLParser.DECIMAL_LITERAL, 0); }
		public DecimalLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitDecimalLiteral(this);
		}
	}

	public final DecimalLiteralContext decimalLiteral() throws RecognitionException {
		DecimalLiteralContext _localctx = new DecimalLiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_decimalLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(DECIMAL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> STRING_LITERAL() { return getTokens(SQLParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(SQLParser.STRING_LITERAL, i);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitStringLiteral(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stringLiteral);
		try {
			int _alt;
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(238);
						match(STRING_LITERAL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(241); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(243);
				match(STRING_LITERAL);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SQLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SQLParser.FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBooleanLiteral(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullNotnullContext extends ParserRuleContext {
		public TerminalNode NULL_LITERAL() { return getToken(SQLParser.NULL_LITERAL, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public NullNotnullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullNotnull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNullNotnull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNullNotnull(this);
		}
	}

	public final NullNotnullContext nullNotnull() throws RecognitionException {
		NullNotnullContext _localctx = new NullNotnullContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_nullNotnull);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(248);
				match(NOT);
				}
			}

			setState(251);
			match(NULL_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public Token nullLiteral;
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public DecimalLiteralContext decimalLiteral() {
			return getRuleContext(DecimalLiteralContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public TerminalNode NULL_LITERAL() { return getToken(SQLParser.NULL_LITERAL, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constant);
		int _la;
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				stringLiteral();
				}
				break;
			case DECIMAL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				decimalLiteral();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				match(MINUS);
				setState(256);
				decimalLiteral();
				}
				break;
			case FALSE:
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				booleanLiteral();
				}
				break;
			case NOT:
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(258);
					match(NOT);
					}
				}

				setState(261);
				((ConstantContext)_localctx).nullLiteral = match(NULL_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	 
		public FunctionCallContext() { }
		public void copyFrom(FunctionCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UdfFunctionCallContext extends FunctionCallContext {
		public UidContext uid() {
			return getRuleContext(UidContext.class,0);
		}
		public TerminalNode LR_BRACKET() { return getToken(SQLParser.LR_BRACKET, 0); }
		public TerminalNode RR_BRACKET() { return getToken(SQLParser.RR_BRACKET, 0); }
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public UdfFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterUdfFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitUdfFunctionCall(this);
		}
	}
	public static class AggregateFunctionCallContext extends FunctionCallContext {
		public AggregateWindowedFunctionContext aggregateWindowedFunction() {
			return getRuleContext(AggregateWindowedFunctionContext.class,0);
		}
		public AggregateFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAggregateFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAggregateFunctionCall(this);
		}
	}
	public static class ScalarFunctionCallContext extends FunctionCallContext {
		public FunctionNameBaseContext functionNameBase() {
			return getRuleContext(FunctionNameBaseContext.class,0);
		}
		public TerminalNode LR_BRACKET() { return getToken(SQLParser.LR_BRACKET, 0); }
		public TerminalNode RR_BRACKET() { return getToken(SQLParser.RR_BRACKET, 0); }
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public ScalarFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterScalarFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitScalarFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionCall);
		int _la;
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new AggregateFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				aggregateWindowedFunction();
				}
				break;
			case 2:
				_localctx = new ScalarFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				functionNameBase();
				setState(266);
				match(LR_BRACKET);
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << NOT) | (1L << NULL_LITERAL) | (1L << TRUE) | (1L << AVG) | (1L << COUNT) | (1L << MAX) | (1L << MIN) | (1L << SUM) | (1L << MINUS) | (1L << EXCLAMATION_SYMBOL) | (1L << LR_BRACKET) | (1L << STRING_LITERAL) | (1L << DECIMAL_LITERAL) | (1L << ID))) != 0)) {
					{
					setState(267);
					functionArgs();
					}
				}

				setState(270);
				match(RR_BRACKET);
				}
				break;
			case 3:
				_localctx = new UdfFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
				uid();
				setState(273);
				match(LR_BRACKET);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << NOT) | (1L << NULL_LITERAL) | (1L << TRUE) | (1L << AVG) | (1L << COUNT) | (1L << MAX) | (1L << MIN) | (1L << SUM) | (1L << MINUS) | (1L << EXCLAMATION_SYMBOL) | (1L << LR_BRACKET) | (1L << STRING_LITERAL) | (1L << DECIMAL_LITERAL) | (1L << ID))) != 0)) {
					{
					setState(274);
					functionArgs();
					}
				}

				setState(277);
				match(RR_BRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregateWindowedFunctionContext extends ParserRuleContext {
		public Token aggregator;
		public Token starArg;
		public TerminalNode LR_BRACKET() { return getToken(SQLParser.LR_BRACKET, 0); }
		public FunctionArgContext functionArg() {
			return getRuleContext(FunctionArgContext.class,0);
		}
		public TerminalNode RR_BRACKET() { return getToken(SQLParser.RR_BRACKET, 0); }
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode SUM() { return getToken(SQLParser.SUM, 0); }
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode DISTINCT() { return getToken(SQLParser.DISTINCT, 0); }
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public AggregateWindowedFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateWindowedFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterAggregateWindowedFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitAggregateWindowedFunction(this);
		}
	}

	public final AggregateWindowedFunctionContext aggregateWindowedFunction() throws RecognitionException {
		AggregateWindowedFunctionContext _localctx = new AggregateWindowedFunctionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_aggregateWindowedFunction);
		int _la;
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AVG) | (1L << MAX) | (1L << MIN) | (1L << SUM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(282);
				match(LR_BRACKET);
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(283);
					((AggregateWindowedFunctionContext)_localctx).aggregator = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
						((AggregateWindowedFunctionContext)_localctx).aggregator = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(286);
				functionArg();
				setState(287);
				match(RR_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(COUNT);
				setState(290);
				match(LR_BRACKET);
				setState(296);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(291);
					((AggregateWindowedFunctionContext)_localctx).starArg = match(STAR);
					}
					break;
				case ALL:
				case FALSE:
				case NOT:
				case NULL_LITERAL:
				case TRUE:
				case AVG:
				case COUNT:
				case MAX:
				case MIN:
				case SUM:
				case MINUS:
				case EXCLAMATION_SYMBOL:
				case LR_BRACKET:
				case STRING_LITERAL:
				case DECIMAL_LITERAL:
				case ID:
					{
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL) {
						{
						setState(292);
						((AggregateWindowedFunctionContext)_localctx).aggregator = match(ALL);
						}
					}

					setState(295);
					functionArg();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(298);
				match(RR_BRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				match(COUNT);
				setState(300);
				match(LR_BRACKET);
				setState(301);
				((AggregateWindowedFunctionContext)_localctx).aggregator = match(DISTINCT);
				setState(302);
				functionArgs();
				setState(303);
				match(RR_BRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgsContext extends ParserRuleContext {
		public List<FunctionArgContext> functionArg() {
			return getRuleContexts(FunctionArgContext.class);
		}
		public FunctionArgContext functionArg(int i) {
			return getRuleContext(FunctionArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public FunctionArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunctionArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunctionArgs(this);
		}
	}

	public final FunctionArgsContext functionArgs() throws RecognitionException {
		FunctionArgsContext _localctx = new FunctionArgsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			functionArg();
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(308);
				match(COMMA);
				setState(309);
				functionArg();
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FullColumnNameContext fullColumnName() {
			return getRuleContext(FullColumnNameContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunctionArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunctionArg(this);
		}
	}

	public final FunctionArgContext functionArg() throws RecognitionException {
		FunctionArgContext _localctx = new FunctionArgContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_functionArg);
		try {
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				constant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				fullColumnName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(318);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IsExpressionContext extends ExpressionContext {
		public Token testValue;
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode IS() { return getToken(SQLParser.IS, 0); }
		public TerminalNode TRUE() { return getToken(SQLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SQLParser.FALSE, 0); }
		public IsExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIsExpression(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public Token notOperator;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode EXCLAMATION_SYMBOL() { return getToken(SQLParser.EXCLAMATION_SYMBOL, 0); }
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNotExpression(this);
		}
	}
	public static class LogicalExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalOperatorContext logicalOperator() {
			return getRuleContext(LogicalOperatorContext.class,0);
		}
		public LogicalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitLogicalExpression(this);
		}
	}
	public static class PredicateExpressionContext extends ExpressionContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicateExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterPredicateExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitPredicateExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(322);
				((NotExpressionContext)_localctx).notOperator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==EXCLAMATION_SYMBOL) ) {
					((NotExpressionContext)_localctx).notOperator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(323);
				expression(4);
				}
				break;
			case 2:
				{
				_localctx = new IsExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(324);
				predicate(0);
				setState(325);
				match(IS);
				setState(326);
				((IsExpressionContext)_localctx).testValue = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FALSE || _la==TRUE) ) {
					((IsExpressionContext)_localctx).testValue = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				{
				_localctx = new PredicateExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(328);
				predicate(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(337);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(331);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(332);
					logicalOperator();
					setState(333);
					expression(4);
					}
					} 
				}
				setState(339);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	 
		public PredicateContext() { }
		public void copyFrom(PredicateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpressionAtomPredicateContext extends PredicateContext {
		public ExpressionAtomContext expressionAtom() {
			return getRuleContext(ExpressionAtomContext.class,0);
		}
		public ExpressionAtomPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterExpressionAtomPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitExpressionAtomPredicate(this);
		}
	}
	public static class SubqueryComparasionPredicateContext extends PredicateContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public TerminalNode LR_BRACKET() { return getToken(SQLParser.LR_BRACKET, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode RR_BRACKET() { return getToken(SQLParser.RR_BRACKET, 0); }
		public SubqueryComparasionPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSubqueryComparasionPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSubqueryComparasionPredicate(this);
		}
	}
	public static class BinaryComparasionPredicateContext extends PredicateContext {
		public PredicateContext left;
		public PredicateContext right;
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public BinaryComparasionPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterBinaryComparasionPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitBinaryComparasionPredicate(this);
		}
	}
	public static class IsNullPredicateContext extends PredicateContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode IS() { return getToken(SQLParser.IS, 0); }
		public NullNotnullContext nullNotnull() {
			return getRuleContext(NullNotnullContext.class,0);
		}
		public IsNullPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterIsNullPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitIsNullPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		return predicate(0);
	}

	private PredicateContext predicate(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PredicateContext _localctx = new PredicateContext(_ctx, _parentState);
		PredicateContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_predicate, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExpressionAtomPredicateContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(341);
			expressionAtom(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(356);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryComparasionPredicateContext(new PredicateContext(_parentctx, _parentState));
						((BinaryComparasionPredicateContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(343);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(344);
						comparisonOperator();
						setState(345);
						((BinaryComparasionPredicateContext)_localctx).right = predicate(4);
						}
						break;
					case 2:
						{
						_localctx = new IsNullPredicateContext(new PredicateContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(347);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(348);
						match(IS);
						setState(349);
						nullNotnull();
						}
						break;
					case 3:
						{
						_localctx = new SubqueryComparasionPredicateContext(new PredicateContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_predicate);
						setState(350);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(351);
						comparisonOperator();
						setState(352);
						match(LR_BRACKET);
						setState(353);
						selectStatement();
						setState(354);
						match(RR_BRACKET);
						}
						break;
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionAtomContext extends ParserRuleContext {
		public ExpressionAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAtom; }
	 
		public ExpressionAtomContext() { }
		public void copyFrom(ExpressionAtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryExpessionAtomContext extends ExpressionAtomContext {
		public TerminalNode LR_BRACKET() { return getToken(SQLParser.LR_BRACKET, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode RR_BRACKET() { return getToken(SQLParser.RR_BRACKET, 0); }
		public SubqueryExpessionAtomContext(ExpressionAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterSubqueryExpessionAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitSubqueryExpessionAtom(this);
		}
	}
	public static class ConstantExpressionAtomContext extends ExpressionAtomContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExpressionAtomContext(ExpressionAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterConstantExpressionAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitConstantExpressionAtom(this);
		}
	}
	public static class FunctionCallExpressionAtomContext extends ExpressionAtomContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionAtomContext(ExpressionAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunctionCallExpressionAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunctionCallExpressionAtom(this);
		}
	}
	public static class FullColumnNameExpressionAtomContext extends ExpressionAtomContext {
		public FullColumnNameContext fullColumnName() {
			return getRuleContext(FullColumnNameContext.class,0);
		}
		public FullColumnNameExpressionAtomContext(ExpressionAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFullColumnNameExpressionAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFullColumnNameExpressionAtom(this);
		}
	}
	public static class NestedExpressionAtomContext extends ExpressionAtomContext {
		public TerminalNode LR_BRACKET() { return getToken(SQLParser.LR_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RR_BRACKET() { return getToken(SQLParser.RR_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public NestedExpressionAtomContext(ExpressionAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterNestedExpressionAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitNestedExpressionAtom(this);
		}
	}
	public static class MathExpressionAtomContext extends ExpressionAtomContext {
		public ExpressionAtomContext left;
		public ExpressionAtomContext right;
		public MathOperatorContext mathOperator() {
			return getRuleContext(MathOperatorContext.class,0);
		}
		public List<ExpressionAtomContext> expressionAtom() {
			return getRuleContexts(ExpressionAtomContext.class);
		}
		public ExpressionAtomContext expressionAtom(int i) {
			return getRuleContext(ExpressionAtomContext.class,i);
		}
		public MathExpressionAtomContext(ExpressionAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterMathExpressionAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitMathExpressionAtom(this);
		}
	}

	public final ExpressionAtomContext expressionAtom() throws RecognitionException {
		return expressionAtom(0);
	}

	private ExpressionAtomContext expressionAtom(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionAtomContext _localctx = new ExpressionAtomContext(_ctx, _parentState);
		ExpressionAtomContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_expressionAtom, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				_localctx = new ConstantExpressionAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(362);
				constant();
				}
				break;
			case 2:
				{
				_localctx = new FullColumnNameExpressionAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(363);
				fullColumnName();
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallExpressionAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(364);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new NestedExpressionAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(365);
				match(LR_BRACKET);
				setState(366);
				expression(0);
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(367);
					match(COMMA);
					setState(368);
					expression(0);
					}
					}
					setState(373);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(374);
				match(RR_BRACKET);
				}
				break;
			case 5:
				{
				_localctx = new SubqueryExpessionAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(376);
				match(LR_BRACKET);
				setState(377);
				selectStatement();
				setState(378);
				match(RR_BRACKET);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(388);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MathExpressionAtomContext(new ExpressionAtomContext(_parentctx, _parentState));
					((MathExpressionAtomContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expressionAtom);
					setState(382);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(383);
					mathOperator();
					setState(384);
					((MathExpressionAtomContext)_localctx).right = expressionAtom(2);
					}
					} 
				}
				setState(390);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQUAL_SYMBOL() { return getToken(SQLParser.EQUAL_SYMBOL, 0); }
		public TerminalNode GREATER_SYMBOL() { return getToken(SQLParser.GREATER_SYMBOL, 0); }
		public TerminalNode EXCLAMATION_SYMBOL() { return getToken(SQLParser.EXCLAMATION_SYMBOL, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitComparisonOperator(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_comparisonOperator);
		try {
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				match(EQUAL_SYMBOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(392);
				match(GREATER_SYMBOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				match(GREATER_SYMBOL);
				setState(394);
				match(EQUAL_SYMBOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(395);
				match(EXCLAMATION_SYMBOL);
				setState(396);
				match(EQUAL_SYMBOL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOperatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(SQLParser.AND, 0); }
		public TerminalNode OR() { return getToken(SQLParser.OR, 0); }
		public LogicalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterLogicalOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitLogicalOperator(this);
		}
	}

	public final LogicalOperatorContext logicalOperator() throws RecognitionException {
		LogicalOperatorContext _localctx = new LogicalOperatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_logicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathOperatorContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public TerminalNode DIVIDE() { return getToken(SQLParser.DIVIDE, 0); }
		public TerminalNode MODULE() { return getToken(SQLParser.MODULE, 0); }
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public MathOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterMathOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitMathOperator(this);
		}
	}

	public final MathOperatorContext mathOperator() throws RecognitionException {
		MathOperatorContext _localctx = new MathOperatorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_mathOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIVIDE) | (1L << MODULE) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionNameBaseContext extends ParserRuleContext {
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode SUM() { return getToken(SQLParser.SUM, 0); }
		public FunctionNameBaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionNameBase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).enterFunctionNameBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLParserListener ) ((SQLParserListener)listener).exitFunctionNameBase(this);
		}
	}

	public final FunctionNameBaseContext functionNameBase() throws RecognitionException {
		FunctionNameBaseContext _localctx = new FunctionNameBaseContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_functionNameBase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AVG) | (1L << COUNT) | (1L << MAX) | (1L << MIN) | (1L << SUM))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 26:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 27:
			return predicate_sempred((PredicateContext)_localctx, predIndex);
		case 28:
			return expressionAtom_sempred((ExpressionAtomContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean predicate_sempred(PredicateContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expressionAtom_sempred(ExpressionAtomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0198\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\3\3\3\3\3\6\3K\n\3\r\3\16\3L\3\3\5\3P\n\3\3"+
		"\3\5\3S\n\3\3\3\5\3V\n\3\5\3X\n\3\3\4\3\4\7\4\\\n\4\f\4\16\4_\13\4\3\4"+
		"\3\4\5\4c\n\4\3\4\5\4f\n\4\3\4\5\4i\n\4\3\5\3\5\3\5\3\5\5\5o\n\5\3\6\3"+
		"\6\7\6s\n\6\f\6\16\6v\13\6\3\6\3\6\3\6\7\6{\n\6\f\6\16\6~\13\6\7\6\u0080"+
		"\n\6\f\6\16\6\u0083\13\6\3\7\3\7\5\7\u0087\n\7\3\7\5\7\u008a\n\7\3\7\3"+
		"\7\3\7\3\7\5\7\u0090\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0098\n\7\3\b\5\b"+
		"\u009b\n\b\3\b\3\b\3\b\3\b\5\b\u00a1\n\b\3\t\3\t\5\t\u00a5\n\t\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\5\13\u00ad\n\13\3\13\3\13\7\13\u00b1\n\13\f\13\16\13"+
		"\u00b4\13\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00bc\n\f\3\f\5\f\u00bf\n\f\3"+
		"\f\3\f\5\f\u00c3\n\f\3\f\5\f\u00c6\n\f\5\f\u00c8\n\f\3\r\3\r\3\r\3\r\5"+
		"\r\u00ce\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u00d5\n\r\f\r\16\r\u00d8\13\r\5\r"+
		"\u00da\n\r\3\r\3\r\5\r\u00de\n\r\3\16\3\16\5\16\u00e2\n\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\5\22\u00ed\n\22\3\23\3\23\3\24\6\24"+
		"\u00f2\n\24\r\24\16\24\u00f3\3\24\5\24\u00f7\n\24\3\25\3\25\3\26\5\26"+
		"\u00fc\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0106\n\27\3"+
		"\27\5\27\u0109\n\27\3\30\3\30\3\30\3\30\5\30\u010f\n\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u0116\n\30\3\30\3\30\5\30\u011a\n\30\3\31\3\31\3\31\5"+
		"\31\u011f\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0128\n\31\3\31"+
		"\5\31\u012b\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0134\n\31\3"+
		"\32\3\32\3\32\7\32\u0139\n\32\f\32\16\32\u013c\13\32\3\33\3\33\3\33\3"+
		"\33\5\33\u0142\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u014c"+
		"\n\34\3\34\3\34\3\34\3\34\7\34\u0152\n\34\f\34\16\34\u0155\13\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\7\35\u0167\n\35\f\35\16\35\u016a\13\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\7\36\u0174\n\36\f\36\16\36\u0177\13\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u017f\n\36\3\36\3\36\3\36\3\36\7\36\u0185\n\36\f"+
		"\36\16\36\u0188\13\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0190\n\37\3"+
		" \3 \3!\3!\3\"\3\"\3\"\2\5\668:#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@B\2\13\4\2\7\7\n\n\4\2\t\t\21\21\4\2\4\4\13"+
		"\13\4\2\f\f\35\35\4\2\"\"$&\4\2\25\25\62\62\4\2\5\5\30\30\3\2*.\3\2\""+
		"&\2\u01bd\2D\3\2\2\2\4W\3\2\2\2\6Y\3\2\2\2\bj\3\2\2\2\np\3\2\2\2\f\u0097"+
		"\3\2\2\2\16\u009a\3\2\2\2\20\u00a2\3\2\2\2\22\u00a8\3\2\2\2\24\u00ac\3"+
		"\2\2\2\26\u00c7\3\2\2\2\30\u00c9\3\2\2\2\32\u00df\3\2\2\2\34\u00e3\3\2"+
		"\2\2\36\u00e6\3\2\2\2 \u00e8\3\2\2\2\"\u00ec\3\2\2\2$\u00ee\3\2\2\2&\u00f6"+
		"\3\2\2\2(\u00f8\3\2\2\2*\u00fb\3\2\2\2,\u0108\3\2\2\2.\u0119\3\2\2\2\60"+
		"\u0133\3\2\2\2\62\u0135\3\2\2\2\64\u0141\3\2\2\2\66\u014b\3\2\2\28\u0156"+
		"\3\2\2\2:\u017e\3\2\2\2<\u018f\3\2\2\2>\u0191\3\2\2\2@\u0193\3\2\2\2B"+
		"\u0195\3\2\2\2DE\5\4\3\2EF\7\67\2\2F\3\3\2\2\2GX\5\6\4\2HJ\5\6\4\2IK\5"+
		"\20\t\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NP\5\20\t\2O"+
		"N\3\2\2\2OP\3\2\2\2PR\3\2\2\2QS\5\b\5\2RQ\3\2\2\2RS\3\2\2\2SU\3\2\2\2"+
		"TV\5\34\17\2UT\3\2\2\2UV\3\2\2\2VX\3\2\2\2WG\3\2\2\2WH\3\2\2\2X\5\3\2"+
		"\2\2Y]\7\34\2\2Z\\\5\22\n\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^"+
		"`\3\2\2\2_]\3\2\2\2`b\5\24\13\2ac\5\30\r\2ba\3\2\2\2bc\3\2\2\2ce\3\2\2"+
		"\2df\5\b\5\2ed\3\2\2\2ef\3\2\2\2fh\3\2\2\2gi\5\34\17\2hg\3\2\2\2hi\3\2"+
		"\2\2i\7\3\2\2\2jk\7\31\2\2kl\7\b\2\2ln\5\66\34\2mo\t\2\2\2nm\3\2\2\2n"+
		"o\3\2\2\2o\t\3\2\2\2pt\5\f\7\2qs\5\16\b\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2"+
		"\2tu\3\2\2\2u\u0081\3\2\2\2vt\3\2\2\2wx\7\66\2\2x|\5\f\7\2y{\5\16\b\2"+
		"zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2\177"+
		"w\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\13\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0089\5\36\20\2\u0085\u0087\7\6"+
		"\2\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u008a\5\"\22\2\u0089\u0086\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0098\3"+
		"\2\2\2\u008b\u008c\7\64\2\2\u008c\u008d\5\4\3\2\u008d\u008f\7\65\2\2\u008e"+
		"\u0090\7\6\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0092\5\"\22\2\u0092\u0098\3\2\2\2\u0093\u0094\7\64\2\2\u0094"+
		"\u0095\5\n\6\2\u0095\u0096\7\65\2\2\u0096\u0098\3\2\2\2\u0097\u0084\3"+
		"\2\2\2\u0097\u008b\3\2\2\2\u0097\u0093\3\2\2\2\u0098\r\3\2\2\2\u0099\u009b"+
		"\t\3\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009d\7\23\2\2\u009d\u00a0\5\f\7\2\u009e\u009f\7\27\2\2\u009f\u00a1\5"+
		"\66\34\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\17\3\2\2\2\u00a2"+
		"\u00a4\7\36\2\2\u00a3\u00a5\t\4\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3"+
		"\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\5\6\4\2\u00a7\21\3\2\2\2\u00a8"+
		"\u00a9\t\4\2\2\u00a9\23\3\2\2\2\u00aa\u00ad\7*\2\2\u00ab\u00ad\5\26\f"+
		"\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b2\3\2\2\2\u00ae\u00af"+
		"\7\66\2\2\u00af\u00b1\5\26\f\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2"+
		"\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\25\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b5\u00b6\5\"\22\2\u00b6\u00b7\7\63\2\2\u00b7\u00b8\7*\2\2"+
		"\u00b8\u00c8\3\2\2\2\u00b9\u00be\5 \21\2\u00ba\u00bc\7\6\2\2\u00bb\u00ba"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\5\"\22\2"+
		"\u00be\u00bb\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c8\3\2\2\2\u00c0\u00c5"+
		"\5.\30\2\u00c1\u00c3\7\6\2\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c6\5\"\22\2\u00c5\u00c2\3\2\2\2\u00c5\u00c6\3"+
		"\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00b5\3\2\2\2\u00c7\u00b9\3\2\2\2\u00c7"+
		"\u00c0\3\2\2\2\u00c8\27\3\2\2\2\u00c9\u00ca\7\r\2\2\u00ca\u00cd\5\n\6"+
		"\2\u00cb\u00cc\7 \2\2\u00cc\u00ce\5\66\34\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00d9\3\2\2\2\u00cf\u00d0\7\16\2\2\u00d0\u00d1\7"+
		"\b\2\2\u00d1\u00d6\5\32\16\2\u00d2\u00d3\7\66\2\2\u00d3\u00d5\5\32\16"+
		"\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00cf\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00dc\7\17\2\2\u00dc\u00de\5"+
		"\66\34\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\31\3\2\2\2\u00df"+
		"\u00e1\5\66\34\2\u00e0\u00e2\t\2\2\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3"+
		"\2\2\2\u00e2\33\3\2\2\2\u00e3\u00e4\7\24\2\2\u00e4\u00e5\5$\23\2\u00e5"+
		"\35\3\2\2\2\u00e6\u00e7\5\"\22\2\u00e7\37\3\2\2\2\u00e8\u00e9\5\"\22\2"+
		"\u00e9!\3\2\2\2\u00ea\u00ed\7<\2\2\u00eb\u00ed\5B\"\2\u00ec\u00ea\3\2"+
		"\2\2\u00ec\u00eb\3\2\2\2\u00ed#\3\2\2\2\u00ee\u00ef\7;\2\2\u00ef%\3\2"+
		"\2\2\u00f0\u00f2\7:\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f7\7:"+
		"\2\2\u00f6\u00f1\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\'\3\2\2\2\u00f8\u00f9"+
		"\t\5\2\2\u00f9)\3\2\2\2\u00fa\u00fc\7\25\2\2\u00fb\u00fa\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\7\26\2\2\u00fe+\3\2\2\2"+
		"\u00ff\u0109\5&\24\2\u0100\u0109\5$\23\2\u0101\u0102\7.\2\2\u0102\u0109"+
		"\5$\23\2\u0103\u0109\5(\25\2\u0104\u0106\7\25\2\2\u0105\u0104\3\2\2\2"+
		"\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\7\26\2\2\u0108\u00ff"+
		"\3\2\2\2\u0108\u0100\3\2\2\2\u0108\u0101\3\2\2\2\u0108\u0103\3\2\2\2\u0108"+
		"\u0105\3\2\2\2\u0109-\3\2\2\2\u010a\u011a\5\60\31\2\u010b\u010c\5B\"\2"+
		"\u010c\u010e\7\64\2\2\u010d\u010f\5\62\32\2\u010e\u010d\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\7\65\2\2\u0111\u011a\3"+
		"\2\2\2\u0112\u0113\5\"\22\2\u0113\u0115\7\64\2\2\u0114\u0116\5\62\32\2"+
		"\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118"+
		"\7\65\2\2\u0118\u011a\3\2\2\2\u0119\u010a\3\2\2\2\u0119\u010b\3\2\2\2"+
		"\u0119\u0112\3\2\2\2\u011a/\3\2\2\2\u011b\u011c\t\6\2\2\u011c\u011e\7"+
		"\64\2\2\u011d\u011f\t\4\2\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u0121\5\64\33\2\u0121\u0122\7\65\2\2\u0122\u0134"+
		"\3\2\2\2\u0123\u0124\7#\2\2\u0124\u012a\7\64\2\2\u0125\u012b\7*\2\2\u0126"+
		"\u0128\7\4\2\2\u0127\u0126\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u012b\5\64\33\2\u012a\u0125\3\2\2\2\u012a\u0127\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u0134\7\65\2\2\u012d\u012e\7#\2\2\u012e\u012f\7\64"+
		"\2\2\u012f\u0130\7\13\2\2\u0130\u0131\5\62\32\2\u0131\u0132\7\65\2\2\u0132"+
		"\u0134\3\2\2\2\u0133\u011b\3\2\2\2\u0133\u0123\3\2\2\2\u0133\u012d\3\2"+
		"\2\2\u0134\61\3\2\2\2\u0135\u013a\5\64\33\2\u0136\u0137\7\66\2\2\u0137"+
		"\u0139\5\64\33\2\u0138\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3"+
		"\2\2\2\u013a\u013b\3\2\2\2\u013b\63\3\2\2\2\u013c\u013a\3\2\2\2\u013d"+
		"\u0142\5,\27\2\u013e\u0142\5 \21\2\u013f\u0142\5.\30\2\u0140\u0142\5\66"+
		"\34\2\u0141\u013d\3\2\2\2\u0141\u013e\3\2\2\2\u0141\u013f\3\2\2\2\u0141"+
		"\u0140\3\2\2\2\u0142\65\3\2\2\2\u0143\u0144\b\34\1\2\u0144\u0145\t\7\2"+
		"\2\u0145\u014c\5\66\34\6\u0146\u0147\58\35\2\u0147\u0148\7\22\2\2\u0148"+
		"\u0149\t\5\2\2\u0149\u014c\3\2\2\2\u014a\u014c\58\35\2\u014b\u0143\3\2"+
		"\2\2\u014b\u0146\3\2\2\2\u014b\u014a\3\2\2\2\u014c\u0153\3\2\2\2\u014d"+
		"\u014e\f\5\2\2\u014e\u014f\5> \2\u014f\u0150\5\66\34\6\u0150\u0152\3\2"+
		"\2\2\u0151\u014d\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\67\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\b\35\1"+
		"\2\u0157\u0158\5:\36\2\u0158\u0168\3\2\2\2\u0159\u015a\f\5\2\2\u015a\u015b"+
		"\5<\37\2\u015b\u015c\58\35\6\u015c\u0167\3\2\2\2\u015d\u015e\f\6\2\2\u015e"+
		"\u015f\7\22\2\2\u015f\u0167\5*\26\2\u0160\u0161\f\4\2\2\u0161\u0162\5"+
		"<\37\2\u0162\u0163\7\64\2\2\u0163\u0164\5\4\3\2\u0164\u0165\7\65\2\2\u0165"+
		"\u0167\3\2\2\2\u0166\u0159\3\2\2\2\u0166\u015d\3\2\2\2\u0166\u0160\3\2"+
		"\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"9\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016c\b\36\1\2\u016c\u017f\5,\27\2"+
		"\u016d\u017f\5 \21\2\u016e\u017f\5.\30\2\u016f\u0170\7\64\2\2\u0170\u0175"+
		"\5\66\34\2\u0171\u0172\7\66\2\2\u0172\u0174\5\66\34\2\u0173\u0171\3\2"+
		"\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\7\65\2\2\u0179\u017f\3"+
		"\2\2\2\u017a\u017b\7\64\2\2\u017b\u017c\5\4\3\2\u017c\u017d\7\65\2\2\u017d"+
		"\u017f\3\2\2\2\u017e\u016b\3\2\2\2\u017e\u016d\3\2\2\2\u017e\u016e\3\2"+
		"\2\2\u017e\u016f\3\2\2\2\u017e\u017a\3\2\2\2\u017f\u0186\3\2\2\2\u0180"+
		"\u0181\f\3\2\2\u0181\u0182\5@!\2\u0182\u0183\5:\36\4\u0183\u0185\3\2\2"+
		"\2\u0184\u0180\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187"+
		"\3\2\2\2\u0187;\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u0190\7/\2\2\u018a\u0190"+
		"\7\60\2\2\u018b\u018c\7\60\2\2\u018c\u0190\7/\2\2\u018d\u018e\7\62\2\2"+
		"\u018e\u0190\7/\2\2\u018f\u0189\3\2\2\2\u018f\u018a\3\2\2\2\u018f\u018b"+
		"\3\2\2\2\u018f\u018d\3\2\2\2\u0190=\3\2\2\2\u0191\u0192\t\b\2\2\u0192"+
		"?\3\2\2\2\u0193\u0194\t\t\2\2\u0194A\3\2\2\2\u0195\u0196\t\n\2\2\u0196"+
		"C\3\2\2\29LORUW]behnt|\u0081\u0086\u0089\u008f\u0097\u009a\u00a0\u00a4"+
		"\u00ac\u00b2\u00bb\u00be\u00c2\u00c5\u00c7\u00cd\u00d6\u00d9\u00dd\u00e1"+
		"\u00ec\u00f3\u00f6\u00fb\u0105\u0108\u010e\u0115\u0119\u011e\u0127\u012a"+
		"\u0133\u013a\u0141\u014b\u0153\u0166\u0168\u0175\u017e\u0186\u018f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}