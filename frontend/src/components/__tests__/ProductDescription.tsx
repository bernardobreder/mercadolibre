import { render, screen } from "@testing-library/react";
import ProductDescription from "../ProductDescription";

describe("ProductDescription", () => {
  it("must display the product description", () => {
    render(
      <ProductDescription description="Great performance and vibrant screen" />
    );
    expect(screen.getByText(/ótimo desempenho/i)).toBeInTheDocument();
  });
});
