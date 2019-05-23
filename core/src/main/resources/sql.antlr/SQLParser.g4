parser grammar SQLParser;

options { tokenVocab=SQLLexer; }

sqlStatement
    : selectStatement SEMI
    ;

selectStatement
    : querySpecification                                    #simpleSelect
    | querySpecification unionStatement+ unionStatement?
        orderByClause? limitClause?                         #unionSelect
    ;

querySpecification
    : SELECT selectSpec* selectElements
      fromClause? orderByClause? limitClause?
    ;

orderByClause
    : ORDER BY expression order=(ASC | DESC)?
    ;

tableSources
    : tableSourceItem joinPart* (',' tableSourceItem joinPart*)*
    ;

tableSourceItem
    : tableName (AS? alias=uid)?                                    #atomTableItem
    | '(' parenthesisSubquery=selectStatement ')' AS? alias=uid     #subqueryTableItem
    | '(' tableSources ')'                                          #tableSourcesItem
    ;

joinPart
    : NATURAL JOIN tableSourceItem
    ;

unionStatement
    : UNION unionType=(ALL | DISTINCT)? querySpecification
    ;

selectSpec
    : (ALL | DISTINCT)
    ;

selectElements
    : (star='*' | selectElement) (',' selectElement)*
    ;

selectElement
    : uid '.' '*'                                     #selectStarElement
    | fullColumnName (AS? uid)?                       #selectColumnElement
    | functionCall (AS? uid)?                         #selectFunctionElement
    ;

fromClause
    : FROM tableSources
      (WHERE whereExpr=expression)?
      (
        GROUP BY
        groupByItem (',' groupByItem)*
      )?
      (HAVING havingExpr=expression)?
    ;

groupByItem
    : expression order=(ASC | DESC)?
    ;

limitClause
    : LIMIT limit=decimalLiteral
    ;

tableName
    : uid
    ;

fullColumnName
    : uid
    ;

uid
    : ID
    | functionNameBase
    ;

decimalLiteral
    : DECIMAL_LITERAL
    ;

stringLiteral
    : STRING_LITERAL+
    | (STRING_LITERAL)
    ;

booleanLiteral
    : TRUE | FALSE;

nullNotnull
    : NOT? NULL_LITERAL
    ;

constant
    : stringLiteral | decimalLiteral
    | '-' decimalLiteral
    | booleanLiteral
    | NOT? nullLiteral=NULL_LITERAL
    ;

functionCall
    : aggregateWindowedFunction                                     #aggregateFunctionCall
    | functionNameBase '(' functionArgs? ')'                      #scalarFunctionCall
    | uid '(' functionArgs? ')'                                     #udfFunctionCall
    ;

aggregateWindowedFunction
    : (AVG | MAX | MIN | SUM)
      '(' aggregator=(ALL | DISTINCT)? functionArg ')'
    | COUNT '(' (starArg='*' | aggregator=ALL? functionArg) ')'
    | COUNT '(' aggregator=DISTINCT functionArgs ')'
    ;

functionArgs
    : functionArg (',' functionArg)*
    ;

functionArg
    : constant | fullColumnName | functionCall | expression
    ;


// Expressions, predicates

expression
    : notOperator=(NOT | '!') expression                            #notExpression
    | expression logicalOperator expression                         #logicalExpression
    | predicate IS testValue=(TRUE | FALSE)                    #isExpression
    | predicate                                                     #predicateExpression
    ;

predicate
    : predicate IS nullNotnull                                      #isNullPredicate
    | left=predicate comparisonOperator right=predicate             #binaryComparasionPredicate
    | predicate comparisonOperator '(' selectStatement ')'          #subqueryComparasionPredicate
    | expressionAtom                                                #expressionAtomPredicate
    ;

expressionAtom
    : constant                                                      #constantExpressionAtom
    | fullColumnName                                                #fullColumnNameExpressionAtom
    | functionCall                                                  #functionCallExpressionAtom
    | '(' expression (',' expression)* ')'                          #nestedExpressionAtom
    | '(' selectStatement ')'                                       #subqueryExpessionAtom
    | left=expressionAtom mathOperator right=expressionAtom         #mathExpressionAtom
    ;

comparisonOperator
    : '=' | '>' | '>' '=' | '!' '='
    ;

logicalOperator
    : AND | OR
    ;

mathOperator
    : '*' | '/' | '%' | '+' | '-'
    ;

functionNameBase
    : AVG | COUNT | MAX | MIN | SUM
    ;
