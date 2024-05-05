export let cachedSearchWords = {}

cachedSearchWords.c = `{
    "missed": {"ht": {}, "totalDensity": 0},
    "matched": {"ht": {}, "totalDensity": 0},
    "combinedMatchedBecause": {
    },
    "combinedMissed": {
        "ht": {
        }, "totalDensity": 0
    },
    "combinedSuperfluous": {
        "ht": {
        }, "totalDensity": 0
    },
    "matchPercentage": 0
}`

cachedSearchWords.reset = () => {
    cachedSearchWords.c = `{
    "missed": {"ht": {}, "totalDensity": 0},
    "matched": {"ht": {}, "totalDensity": 0},
    "combinedMatchedBecause": {
    },
    "combinedSuperfluous": {
        "ht": {
        }, "totalDensity": 0
    },
    "matchPercentage": 0
}`
}