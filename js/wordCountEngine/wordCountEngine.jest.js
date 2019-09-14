const alg = require(process.env.PWD.concat('wordCountEngine'));

describe('alg', () => {
  test('must not have errors', () => {
    console.log(alg.maintainDictionary({}, 'word'))
    expect(alg.maintainDictionary({}, 'word')).toEqual(null);
  });
});
