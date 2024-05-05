import { render, screen } from '@testing-library/react';
import App from '../App';

let consoleError;

beforeEach(() => {
  consoleError = console.error

  console.error = function (message) {
    consoleError.apply(console, arguments)
    throw new Error(message)
  }
})

afterEach(() => {
  console.error = consoleError
})
test('renders learn react link', () => {
  render(<App searchWordsAg={{"green":[], "yellow": []}}/>);
  const linkElement = screen.getByText(/JudeaDumont/i);
  expect(linkElement).toBeInTheDocument();
});
