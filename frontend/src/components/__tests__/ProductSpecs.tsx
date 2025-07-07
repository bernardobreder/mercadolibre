import { render, screen } from "@testing-library/react";
import ProductSpecs from "../ProductSpecs";

describe("ProductSpecs", () => {
  it("deve renderizar todas as especificações", () => {
    const specs = [
      'Tela: 6.6"',
      "Memória: 256 GB",
      "Câmera Principal: 50 MP",
      "Frontal: 32 MP",
      "NFC: Sim",
    ];

    render(<ProductSpecs specs={specs} />);

    specs.forEach((spec) => {
      expect(screen.getByText(spec)).toBeInTheDocument();
    });
  });
});
