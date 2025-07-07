import { render, screen } from "@testing-library/react";
import ProductRating from "../ProductRating";

describe("ProductRating", () => {
  it("deve mostrar a avaliação do produto", () => {
    render(<ProductRating rating={4.5} />);
    expect(screen.getByText(/avaliação: 4.5/i)).toBeInTheDocument();
  });
});
