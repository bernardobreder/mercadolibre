import { render, screen } from "@testing-library/react";
import ProductDescription from "../ProductDescription";

describe("ProductDescription", () => {
  it("deve exibir a descrição do produto", () => {
    render(
      <ProductDescription description="Ótimo desempenho e screenSize vibrante" />
    );
    expect(screen.getByText(/ótimo desempenho/i)).toBeInTheDocument();
  });
});
