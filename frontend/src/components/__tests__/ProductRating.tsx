import { render, screen } from "@testing-library/react";
import ProductRating from "../ProductRating";

describe("ProductRating", () => {
  it("must display the product rating", () => {
    render(<ProductRating rating={4.5} />);
    expect(screen.getByText(/avaliação: 4.5/i)).toBeInTheDocument();
  });
});
