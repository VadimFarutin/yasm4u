// Generated from C:/Users/Vadim/Documents/IdeaProjects/yasm4u/core/src/main/resources/sql.antlr\SQLParser.g4 by ANTLR 4.7.2
package com.expleague.yasm4u.domains.sql.parser.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatement(SQLParser.SqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatement(SQLParser.SqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleSelect}
	 * labeled alternative in {@link SQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleSelect(SQLParser.SimpleSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleSelect}
	 * labeled alternative in {@link SQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleSelect(SQLParser.SimpleSelectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionSelect}
	 * labeled alternative in {@link SQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnionSelect(SQLParser.UnionSelectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionSelect}
	 * labeled alternative in {@link SQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnionSelect(SQLParser.UnionSelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(SQLParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(SQLParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(SQLParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(SQLParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableSources}.
	 * @param ctx the parse tree
	 */
	void enterTableSources(SQLParser.TableSourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableSources}.
	 * @param ctx the parse tree
	 */
	void exitTableSources(SQLParser.TableSourcesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomTableItem}
	 * labeled alternative in {@link SQLParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void enterAtomTableItem(SQLParser.AtomTableItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomTableItem}
	 * labeled alternative in {@link SQLParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void exitAtomTableItem(SQLParser.AtomTableItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryTableItem}
	 * labeled alternative in {@link SQLParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryTableItem(SQLParser.SubqueryTableItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryTableItem}
	 * labeled alternative in {@link SQLParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryTableItem(SQLParser.SubqueryTableItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableSourcesItem}
	 * labeled alternative in {@link SQLParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void enterTableSourcesItem(SQLParser.TableSourcesItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableSourcesItem}
	 * labeled alternative in {@link SQLParser#tableSourceItem}.
	 * @param ctx the parse tree
	 */
	void exitTableSourcesItem(SQLParser.TableSourcesItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void enterJoinPart(SQLParser.JoinPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#joinPart}.
	 * @param ctx the parse tree
	 */
	void exitJoinPart(SQLParser.JoinPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#unionStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnionStatement(SQLParser.UnionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#unionStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnionStatement(SQLParser.UnionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selectSpec}.
	 * @param ctx the parse tree
	 */
	void enterSelectSpec(SQLParser.SelectSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selectSpec}.
	 * @param ctx the parse tree
	 */
	void exitSelectSpec(SQLParser.SelectSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selectElements}.
	 * @param ctx the parse tree
	 */
	void enterSelectElements(SQLParser.SelectElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selectElements}.
	 * @param ctx the parse tree
	 */
	void exitSelectElements(SQLParser.SelectElementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectStarElement}
	 * labeled alternative in {@link SQLParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStarElement(SQLParser.SelectStarElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectStarElement}
	 * labeled alternative in {@link SQLParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStarElement(SQLParser.SelectStarElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectColumnElement}
	 * labeled alternative in {@link SQLParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectColumnElement(SQLParser.SelectColumnElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectColumnElement}
	 * labeled alternative in {@link SQLParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectColumnElement(SQLParser.SelectColumnElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectFunctionElement}
	 * labeled alternative in {@link SQLParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void enterSelectFunctionElement(SQLParser.SelectFunctionElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectFunctionElement}
	 * labeled alternative in {@link SQLParser#selectElement}.
	 * @param ctx the parse tree
	 */
	void exitSelectFunctionElement(SQLParser.SelectFunctionElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(SQLParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(SQLParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#groupByItem}.
	 * @param ctx the parse tree
	 */
	void enterGroupByItem(SQLParser.GroupByItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#groupByItem}.
	 * @param ctx the parse tree
	 */
	void exitGroupByItem(SQLParser.GroupByItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(SQLParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(SQLParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#fullColumnName}.
	 * @param ctx the parse tree
	 */
	void enterFullColumnName(SQLParser.FullColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#fullColumnName}.
	 * @param ctx the parse tree
	 */
	void exitFullColumnName(SQLParser.FullColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#uid}.
	 * @param ctx the parse tree
	 */
	void enterUid(SQLParser.UidContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#uid}.
	 * @param ctx the parse tree
	 */
	void exitUid(SQLParser.UidContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#decimalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(SQLParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#decimalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(SQLParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(SQLParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(SQLParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(SQLParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(SQLParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#nullNotnull}.
	 * @param ctx the parse tree
	 */
	void enterNullNotnull(SQLParser.NullNotnullContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#nullNotnull}.
	 * @param ctx the parse tree
	 */
	void exitNullNotnull(SQLParser.NullNotnullContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(SQLParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(SQLParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aggregateFunctionCall}
	 * labeled alternative in {@link SQLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunctionCall(SQLParser.AggregateFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aggregateFunctionCall}
	 * labeled alternative in {@link SQLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunctionCall(SQLParser.AggregateFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scalarFunctionCall}
	 * labeled alternative in {@link SQLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterScalarFunctionCall(SQLParser.ScalarFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scalarFunctionCall}
	 * labeled alternative in {@link SQLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitScalarFunctionCall(SQLParser.ScalarFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code udfFunctionCall}
	 * labeled alternative in {@link SQLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterUdfFunctionCall(SQLParser.UdfFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code udfFunctionCall}
	 * labeled alternative in {@link SQLParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitUdfFunctionCall(SQLParser.UdfFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#aggregateWindowedFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateWindowedFunction(SQLParser.AggregateWindowedFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#aggregateWindowedFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateWindowedFunction(SQLParser.AggregateWindowedFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgs(SQLParser.FunctionArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgs(SQLParser.FunctionArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArg(SQLParser.FunctionArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArg(SQLParser.FunctionArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isExpression}
	 * labeled alternative in {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIsExpression(SQLParser.IsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isExpression}
	 * labeled alternative in {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIsExpression(SQLParser.IsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(SQLParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(SQLParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(SQLParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(SQLParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExpression}
	 * labeled alternative in {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExpression(SQLParser.PredicateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExpression}
	 * labeled alternative in {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExpression(SQLParser.PredicateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionAtomPredicate}
	 * labeled alternative in {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAtomPredicate(SQLParser.ExpressionAtomPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionAtomPredicate}
	 * labeled alternative in {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAtomPredicate(SQLParser.ExpressionAtomPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryComparasionPredicate}
	 * labeled alternative in {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryComparasionPredicate(SQLParser.SubqueryComparasionPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryComparasionPredicate}
	 * labeled alternative in {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryComparasionPredicate(SQLParser.SubqueryComparasionPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryComparasionPredicate}
	 * labeled alternative in {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterBinaryComparasionPredicate(SQLParser.BinaryComparasionPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryComparasionPredicate}
	 * labeled alternative in {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitBinaryComparasionPredicate(SQLParser.BinaryComparasionPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isNullPredicate}
	 * labeled alternative in {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterIsNullPredicate(SQLParser.IsNullPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isNullPredicate}
	 * labeled alternative in {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitIsNullPredicate(SQLParser.IsNullPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryExpessionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryExpessionAtom(SQLParser.SubqueryExpessionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryExpessionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryExpessionAtom(SQLParser.SubqueryExpessionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpressionAtom(SQLParser.ConstantExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpressionAtom(SQLParser.ConstantExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpressionAtom(SQLParser.FunctionCallExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpressionAtom(SQLParser.FunctionCallExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullColumnNameExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterFullColumnNameExpressionAtom(SQLParser.FullColumnNameExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullColumnNameExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitFullColumnNameExpressionAtom(SQLParser.FullColumnNameExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nestedExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterNestedExpressionAtom(SQLParser.NestedExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nestedExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitNestedExpressionAtom(SQLParser.NestedExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void enterMathExpressionAtom(SQLParser.MathExpressionAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathExpressionAtom}
	 * labeled alternative in {@link SQLParser#expressionAtom}.
	 * @param ctx the parse tree
	 */
	void exitMathExpressionAtom(SQLParser.MathExpressionAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(SQLParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(SQLParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(SQLParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(SQLParser.LogicalOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void enterMathOperator(SQLParser.MathOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#mathOperator}.
	 * @param ctx the parse tree
	 */
	void exitMathOperator(SQLParser.MathOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#functionNameBase}.
	 * @param ctx the parse tree
	 */
	void enterFunctionNameBase(SQLParser.FunctionNameBaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#functionNameBase}.
	 * @param ctx the parse tree
	 */
	void exitFunctionNameBase(SQLParser.FunctionNameBaseContext ctx);
}