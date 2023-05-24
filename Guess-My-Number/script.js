'use strict';

let secretNumber = Math.trunc(Math.random() * 20) + 1;
let score = 20;
let highScore = 0;

const displayMessage = function (message) {
  document.querySelector('.message').textContent = message;
};
//Button "Check!"
document.querySelector('.check').addEventListener('click', function () {
  const number = Number(document.querySelector('.guess').value);

  //When there is no input
  if (!number) {
    displayMessage('❌ No number!');

    //When the user wins
  } else if (number === secretNumber) {
    displayMessage('🏆 Correct Number!');
    document.querySelector('.number').textContent = secretNumber;
    //Style manipulation
    document.querySelector('body').style.backgroundColor = '#60b347';
    document.querySelector('.number').style.width = '30rem';
    if (score > highScore) {
      highScore = score;
      document.querySelector('.highscore').textContent = highScore;
    }
    //When the number is wrong
  } else if (number !== secretNumber) {
    if (score > 1) {
      displayMessage(number > secretNumber ? '📈 Too high' : '📉 Too low');
      score--;
      document.querySelector('.score').textContent = score;
    } else {
      displayMessage('You lost the game');
      document.querySelector('.score').textContent = 0;
    }
  }
});

//Button "Again!"
document.querySelector('.again').addEventListener('click', function () {
  document.querySelector('.number').textContent = '?';
  displayMessage('Start guessing...');
  score = 20;
  secretNumber = Math.trunc(Math.random() * 20) + 1;
  document.querySelector('.score').textContent = '20';
  document.querySelector('body').style.backgroundColor = '#222';
  document.querySelector('.number').style.width = '15rem';
  document.querySelector('.guess').value = '';
  document.querySelector('.highscore').textContent = highScore;
});
