lexer grammar SQLLexer;

channels { ERRORCHANNEL }

SPACE:                               [ \t\r\n]+    -> channel(HIDDEN);

// Keywords

ALL:                                 'ALL';
AND:                                 'AND';
AS:                                  'AS';
ASC:                                 'ASC';
BY:                                  'BY';
DESC:                                'DESC';
DISTINCT:                            'DISTINCT';
FALSE:                               'FALSE';
FROM:                                'FROM';
GROUP:                               'GROUP';
HAVING:                              'HAVING';
IN:                                  'IN';
IS:                                  'IS';
JOIN:                                'JOIN';
LIMIT:                               'LIMIT';
NATURAL:                             'NATURAL';
NOT:                                 'NOT';
NULL_LITERAL:                        'NULL';
ON:                                  'ON';
OR:                                  'OR';
ORDER:                               'ORDER';
OUTER:                               'OUTER';
RIGHT:                               'RIGHT';
SELECT:                              'SELECT';
TRUE:                                'TRUE';
UNION:                               'UNION';
UNIQUE:                              'UNIQUE';
WHERE:                               'WHERE';
WITH:                                'WITH';

// Group functions

AVG:                                 'AVG';
COUNT:                               'COUNT';
MAX:                                 'MAX';
MIN:                                 'MIN';
SUM:                                 'SUM';

// Functions

ABS:                                 'ABS';
CEILING:                             'CEILING';
FLOOR:                               'FLOOR';

// Operators

STAR:                                '*';
DIVIDE:                              '/';
MODULE:                              '%';
PLUS:                                '+';
MINUS:                               '-';

EQUAL_SYMBOL:                        '=';
GREATER_SYMBOL:                      '>';
LESS_SYMBOL:                         '<';
EXCLAMATION_SYMBOL:                  '!';

// Constructors symbols

DOT:                                 '.';
LR_BRACKET:                          '(';
RR_BRACKET:                          ')';
COMMA:                               ',';
SEMI:                                ';';
SINGLE_QUOTE_SYMB:                   '\'';
DOUBLE_QUOTE_SYMB:                   '"';

// Literals

STRING_LITERAL:                      DQUOTA_STRING | SQUOTA_STRING;
DECIMAL_LITERAL:                     DEC_DIGIT+;

ID:                                  [A-Z_$0-9]*?[A-Z_$]+?[A-Z_$0-9]*;
DQUOTA_STRING:                       '"' ( '\\'. | '""' | ~('"'| '\\') )* '"';
SQUOTA_STRING:                       '\'' ('\\'. | '\'\'' | ~('\'' | '\\'))* '\'';
DEC_DIGIT:                           [0-9];

ERROR_RECONGNIGION:                  .    -> channel(ERRORCHANNEL);
