export function hugeMatchingRegularExpression(word) {
    let beginMatch = '(?<=\\s|^|,|-|\\.|;)';
    let endMatch = '(?=\\s|$|,\\s|-|,|\\.|;)';
    let literalMatch = /[.*+?^${}()|[\]\\]/g;
    let literalReplace = '\\$&';
    return new RegExp(
        beginMatch +
        word.replaceAll(literalMatch, literalReplace) +
        endMatch
        + '|' +
        beginMatch +
        (word + 's').replaceAll(literalMatch, literalReplace) +
        endMatch
        + '|' +
        beginMatch +
        (word + 'ing').replaceAll(literalMatch, literalReplace) +
        endMatch
        + '|' +
        beginMatch +
        (word.replaceAll("-", " ")).replaceAll(literalMatch, literalReplace) +
        endMatch
        + '|' +
        beginMatch +
        (word.replaceAll(" ", "-")).replaceAll(literalMatch, literalReplace) +
        endMatch

        , "g"
    );
}