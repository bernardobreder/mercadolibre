import { render, screen } from "@testing-library/react";
import ProductDescription from "../ProductDescription";

describe("ProductDescription", () => {
  it("deve exibir a descrição do produto", () => {
    render(<ProductDescription descricao="Ótimo desempenho e tela vibrante" />);
    expect(screen.getByText(/ótimo desempenho/i)).toBeInTheDocument();
  });
});
